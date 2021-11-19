package board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.domain.SearchDTO;
import board.service.BoardSearchService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardSearchAction implements BoardAction {

	private String path;
	
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		
		// 검색 폼에서 넘긴 값 가져오기
		SearchDTO searchDto = new SearchDTO();
		searchDto.setCriteria(request.getParameter("criteria"));
		searchDto.setKeyword(request.getParameter("keyword"));
		
		// 서비스 요청
		BoardSearchService service = new BoardSearchService();
		List<BoardDTO> searchList = service.search(searchDto);
		
		request.setAttribute("list", searchList);
		request.setAttribute("searchDto", searchDto);
		
		return new BoardActionForward(path, false);
	}

}
