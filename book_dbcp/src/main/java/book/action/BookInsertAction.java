package book.action;

import javax.servlet.http.HttpServletRequest;

import book.domain.BookDTO;
import book.service.BookInsertService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookInsertAction implements BookAction {
	
	private String path;

	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		// insert.jsp에서 넘긴 값 가져오기
		BookDTO insertDto = new BookDTO();
		insertDto.setCode(request.getParameter("code"));
		insertDto.setTitle(request.getParameter("title"));
		insertDto.setWriter(request.getParameter("writer"));
		insertDto.setPrice(Integer.parseInt(request.getParameter("price")));
		
		// service에게 db 작업 요청
		BookInsertService service = new BookInsertService();
		boolean insertFlag = service.bookInsert(insertDto);
		
		// 결과에 따라서 페이지 이동
		if(!insertFlag) {
			path = "/index.jsp?tab=insert";
		}
		
		return new BookActionForward(path, true);
	}

}
