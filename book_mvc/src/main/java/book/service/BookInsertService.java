package book.service;

import static book.persistence.JdbcUtil.*;

import java.sql.Connection;

import book.domain.BookDTO;
import book.persistence.BookDAO;

public class BookInsertService {
	public boolean bookInsert(BookDTO insertDto) {
		
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		
		boolean insertFlag = dao.insert(insertDto);
		
		if(insertFlag) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return insertFlag;

	}
}
