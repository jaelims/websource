package book.action;

import javax.servlet.http.HttpServletRequest;

import book.service.BookDeleteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookDeleteAction implements BookAction {

	private String path;
	
	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		
		String code = request.getParameter("code");
		
		BookDeleteService service = new BookDeleteService();
		boolean deleteFlag = service.bookDelete(code);
		
		if(!deleteFlag) {
			path ="/index.jsp?tab=delete";
		}
		
		return new BookActionForward(path, true);
	}

}
