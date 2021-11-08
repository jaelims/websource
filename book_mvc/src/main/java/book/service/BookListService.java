package book.service;

import java.sql.Connection;
import java.util.List;

import book.domain.BookDTO;
import book.persistence.BookDAO;

import static book.persistence.JdbcUtil.*;

public class BookListService {
	public List<BookDTO> getList(){
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		
		List<BookDTO> list = dao.list();
		
		close(con);
		
		return list;
	}
}
