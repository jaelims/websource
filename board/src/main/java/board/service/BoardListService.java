package board.service;

import java.sql.Connection;
import java.util.List;

import board.domain.BoardDTO;
import board.persistence.BoardDAO;

import static board.persistence.JdbcUtil.*;

public class BoardListService {
	public List<BoardDTO> all(){
		
		// Connection con = JdbcUtil.getConnection();
		
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		List<BoardDTO> list = dao.getList();
		
		// JdbcUtil.close(con);
		close(con);
		
		return list;
		
	}
}
