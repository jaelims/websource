package board.action;

import javax.servlet.http.HttpServletRequest;

import board.service.BoardCountService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardCountUpdateAction implements BoardAction {

	private String path;
	
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// 조회수 변경
		BoardCountService countService = new BoardCountService();
		countService.readUpdate(bno);
		
		path += "?bno="+bno;
		
		return new BoardActionForward(path, true);
	}

}
