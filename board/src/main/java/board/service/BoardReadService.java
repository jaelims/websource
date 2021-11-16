package board.service;

import board.domain.BoardDTO;
import board.persistence.BoardDAO;

import static board.persistence.JdbcUtil.*;

import java.sql.Connection;

public class BoardReadService {
	public BoardDTO read(int bno) {
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		BoardDTO readDto = dao.getRow(bno);
		
		close(con);
		
		return readDto;
	}
}
