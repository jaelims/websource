package board.service;

import static board.persistence.JdbcUtil.*;

import java.sql.Connection;

import board.domain.SearchDTO;
import board.persistence.BoardDAO;

public class BoardTotalRowsService {
	public int totalRows(SearchDTO searchDto) {
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		int total = dao.totalRows(searchDto);
		
		close(con);
		
		return total;
	}
}
