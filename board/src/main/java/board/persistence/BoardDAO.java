package board.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.domain.BoardDTO;
import board.domain.PageDTO;
import board.domain.SearchDTO;

import static board.persistence.JdbcUtil.*;

public class BoardDAO {
	private Connection con;

	public BoardDAO(Connection con) {
		this.con = con;
	}

	public boolean insert(BoardDTO insertDto) {
//		insert into BOARD(bno, title, content, password, attach, name, re_ref, re_lev, re_seq)
//		values(board_seq.nextval,'게시판 작성', '게시판을 작성해 봅시다', '12345', null, '홍길동', board_seq.currval, 0, 0);
		
		PreparedStatement pstmt = null;
		boolean insertFlag = false;
		
		try {
			String sql = "insert into BOARD(bno, title, content, password, attach, name, re_ref, re_lev, re_seq)";
			sql += "values(board_seq.nextval,?,?,?,?,?,board_seq.currval,0,0)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, insertDto.getTitle());
			pstmt.setString(2, insertDto.getContent());
			pstmt.setString(3, insertDto.getPassword());
			pstmt.setString(4, insertDto.getAttach());
			pstmt.setString(5, insertDto.getName());
			
			int result = pstmt.executeUpdate();
			if(result > 0) insertFlag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertFlag;
	}
	
	// 전체 목록 : page 나누기 전
//	public List<BoardDTO> getList(){
//		List<BoardDTO> list = new ArrayList<>();
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			String sql = "select bno, title, name, regdate, readcount, re_lev from board order by re_ref desc, re_seq asc";
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while (rs.next()) {
//				BoardDTO dto = new BoardDTO();
//				dto.setBno(rs.getInt("bno"));
//				dto.setTitle(rs.getString("title"));
//				dto.setName(rs.getString("name"));
//				dto.setRegdate(rs.getDate("regdate"));
//				dto.setReadcount(rs.getInt("readcount"));
//				dto.setRe_lev(rs.getInt("re_lev"));
//				
//				list.add(dto);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//		return list;
//	}
	
	// 전체목록 : page 나누기 적용
	public List<BoardDTO> getList(PageDTO pageDto){
		List<BoardDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			StringBuilder builder = new StringBuilder();
			
			builder.append("select bno, title, name, regdate, readcount, re_lev ");
			builder.append("from (select rownum rnum, A.* ");
			builder.append("from ");
			builder.append("(select bno, title, name, regdate, readcount, re_lev from board ");
			builder.append("where bno > 0 ");
			
			int start = pageDto.getPage()*pageDto.getAmount();
			int end = (pageDto.getPage()-1)*pageDto.getAmount();
			if(!pageDto.getSearchDto().getCriteria().isEmpty()) {
				builder.append("and "+pageDto.getSearchDto().getCriteria()+" like ? ");
				builder.append("order by re_ref desc, re_seq asc) A ");
				builder.append("where rownum <= ?) ");
				builder.append("where rnum > ?");
				
				pstmt = con.prepareStatement(builder.toString());
				pstmt.setString(1, "%"+pageDto.getSearchDto().getKeyword()+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			} else {
				builder.append("order by re_ref desc, re_seq asc) A ");
				builder.append("where rownum <= ?) ");
				builder.append("where rnum > ?");
				
				pstmt = con.prepareStatement(builder.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getDate("regdate"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setRe_lev(rs.getInt("re_lev"));
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	// 전체 게시물 수
	public int totalRows(SearchDTO searchDto) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int total = 0;
		
		try {
			String sql = "";
			if(!searchDto.getCriteria().isEmpty()) {
				sql = "select count(*) from board where "+searchDto.getCriteria()+" like ? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+searchDto.getKeyword()+"%");
			} else {
				sql = "select count(*) from board";
				pstmt = con.prepareStatement(sql);
			}
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) total = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return total;
	}
	
	// 게시글 읽기
	public BoardDTO getRow(int bno) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO readDto = null;
		
		try {
			String sql = "select bno, name, title, content, attach, re_ref, re_seq, re_lev from board where bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				readDto = new BoardDTO();
				readDto.setBno(rs.getInt("bno"));
				readDto.setName(rs.getString("name"));
				readDto.setTitle(rs.getString("title"));
				readDto.setContent(rs.getString("content"));
				readDto.setAttach(rs.getString("attach"));
				
				// 댓글 작업 때문에 추가
				readDto.setRe_ref(rs.getInt("re_ref"));
				readDto.setRe_seq(rs.getInt("re_seq"));
				readDto.setRe_lev(rs.getInt("re_lev"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return readDto;
	}
	
	// 조회수 업데이트
	public boolean readCountUpdate(int bno) {
		PreparedStatement pstmt = null;
		boolean countFlag = false;
		
		try {
			String sql = "update board set readcount = readcount+1 where bno=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			int result = pstmt.executeUpdate();
			if(result > 0) countFlag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return countFlag;
	}
	
	// 게시물 삭제
	public boolean remove(int bno, String password) {
		PreparedStatement pstmt = null;
		boolean removeFlag = false;
		
		try {
			String sql = "delete from board where bno = ? and password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, password);
			
			int result = pstmt.executeUpdate();
			if(result > 0) removeFlag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return removeFlag;
	}
	
	// 게시물 수정
	//
	public boolean update(BoardDTO dto) {
		PreparedStatement pstmt = null;
		boolean updateFlag = false;
		
		try {
			String sql = "";
			if (dto.getAttach() != null) {
				sql = "update board set title = ? ,content= ?, attach = ? where bno = ? and password = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getTitle());
				pstmt.setString(2, dto.getContent());
				pstmt.setString(3, dto.getAttach());
				pstmt.setInt(4, dto.getBno());
				pstmt.setString(5, dto.getPassword());
			} else {
				sql = "update board set title = ? ,content= ? where bno = ? and password = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getTitle());
				pstmt.setString(2, dto.getContent());
				pstmt.setInt(3, dto.getBno());
				pstmt.setString(4, dto.getPassword());
			}
			int result = pstmt.executeUpdate();
			if(result > 0) updateFlag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return updateFlag;
	}
	
	// 댓글 삽입 전 이전 댓글에 대한 정보 업데이트
	public boolean replyUpdate(BoardDTO dto) {
		PreparedStatement pstmt = null;
		boolean replyFlag = false;
		
		try {
			// 원본글에 대한 정보 가져오기
			int re_ref = dto.getRe_ref();
			int re_seq = dto.getRe_seq();
			
			// 원본글에 달려있는 기존 댓글의 re_seq 값 수정(댓글을 최신순으로 정렬)
			String sql = "update BOARD set re_seq = re_seq + 1 where re_ref = ? and re_seq > ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			
			int result = pstmt.executeUpdate();
			if(result > 0) replyFlag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return replyFlag;
	}
	
	// 댓글 삽입
	public boolean replyInsert(BoardDTO dto) {
		boolean insertFlag = false;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into BOARD(bno, title, content, password, attach, name, re_ref, re_seq, re_lev)";
			sql += "values(board_seq.nextval,?,?,?,null,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getPassword());
			pstmt.setString(4, dto.getName());
			pstmt.setInt(5, dto.getRe_ref());
			pstmt.setInt(6, dto.getRe_seq()+1);
			pstmt.setInt(7, dto.getRe_lev()+1);
			
			int result = pstmt.executeUpdate();
			if(result > 0) insertFlag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertFlag;
	}
	
	// 검색
	public List<BoardDTO> searchList(SearchDTO searchDto) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			String sql = "select bno, title, name, regdate, readcount, re_lev from board where "
					+searchDto.getCriteria()+" like ? order by re_ref desc, re_seq asc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+searchDto.getKeyword()+"%");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getDate("regdate"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setRe_lev(rs.getInt("re_lev"));
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
}
