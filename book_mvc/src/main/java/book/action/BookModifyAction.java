package book.action;

import javax.servlet.http.HttpServletRequest;

import book.domain.BookDTO;
import book.service.BookModifyService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookModifyAction implements BookAction {

	private String path;
	
	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		String code = request.getParameter("code");
		int price = Integer.parseInt(request.getParameter("price"));
		
		BookModifyService service = new BookModifyService();
		boolean modifyFlag = service.bookUpdate(code, price);
		
		if(!modifyFlag) {
			path = "index.jsp?tab=modify";
		}

		return new BookActionForward(path, true);
	}

}
