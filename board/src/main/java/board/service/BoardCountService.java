package board.service;

import static board.persistence.JdbcUtil.*;

import java.sql.Connection;

import board.persistence.BoardDAO;

public class BoardCountService {
	public boolean readUpdate(int bno) {
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		boolean countFlag = dao.readCountUpdate(bno);
		
		if (countFlag) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return countFlag;
		
	}
}
