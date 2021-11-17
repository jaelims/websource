package board.service;

import static board.persistence.JdbcUtil.*;

import java.sql.Connection;

import board.persistence.BoardDAO;

public class BoardRemoveService {
	public boolean remove(int bno, String password) {
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		boolean removeFlag = dao.remove(bno, password);
		
		if (removeFlag) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return removeFlag;
	}
}
