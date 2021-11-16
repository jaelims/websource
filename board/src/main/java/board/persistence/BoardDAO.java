package board.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.domain.BoardDTO;

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
	
	// 전체 목록
	public List<BoardDTO> getList(){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select bno, title, name, regdate, readcount from board order by bno desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getDate("regdate"));
				dto.setReadcount(rs.getInt("readcount"));
				
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
	
	// 게시글 읽기
	public BoardDTO getRow(int bno) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO readDto = null;
		
		try {
			String sql = "select bno, name, title, content, attach from board where bno = ?";
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
	
}
