package board.service;

import java.sql.Connection;
import java.util.List;

import board.domain.BoardDTO;
import board.domain.PageDTO;
import board.persistence.BoardDAO;

import static board.persistence.JdbcUtil.*;

public class BoardListService {
	public List<BoardDTO> all(PageDTO pageDto){
		
		// Connection con = JdbcUtil.getConnection();
		
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		List<BoardDTO> list = dao.getList(pageDto);
		
		// JdbcUtil.close(con);
		close(con);
		
		return list;
		
	}
}
