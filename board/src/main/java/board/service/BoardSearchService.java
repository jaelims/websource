package board.service;

import static board.persistence.JdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import board.domain.BoardDTO;
import board.domain.SearchDTO;
import board.persistence.BoardDAO;

public class BoardSearchService {
	public List<BoardDTO> search(SearchDTO searchDto){
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		List<BoardDTO> list = dao.searchList(searchDto);
		
		close(con);
		
		return list;
	}
	
}
