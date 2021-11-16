package book.service;

import java.sql.Connection;
import java.util.List;

import book.domain.BookDTO;
import book.persistence.BookDAO;

import static book.persistence.JdbcUtil.*;

public class BookSearchService {
	public List<BookDTO> search(String criteria, String keyword) {
		
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		
		List<BookDTO> searchlist = dao.search(criteria, keyword);
		
		close(con);
		
		return searchlist;
	}
}
