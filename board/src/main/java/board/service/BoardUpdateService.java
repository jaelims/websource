package board.service;

import static board.persistence.JdbcUtil.*;

import java.sql.Connection;

import board.domain.BoardDTO;
import board.persistence.BoardDAO;

public class BoardUpdateService {
	public boolean update(BoardDTO dto) {
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		boolean updateFlag = dao.update(dto);
		
		if (updateFlag) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return updateFlag;
	}
}
