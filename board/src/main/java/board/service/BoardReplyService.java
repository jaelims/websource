package board.service;

import static board.persistence.JdbcUtil.*;

import java.sql.Connection;

import board.domain.BoardDTO;
import board.persistence.BoardDAO;

public class BoardReplyService {
	public boolean reply(BoardDTO dto) {
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		// replyUpdate
		dao.replyUpdate(dto);
		commit(con);

		// replyInsert
		boolean insertFlag = dao.replyInsert(dto);
		
		if (insertFlag) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return insertFlag;
		
	}
}
