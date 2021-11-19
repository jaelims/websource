package board.action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import board.service.BoardRemoveService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardRemoveAction implements BoardAction {
	
	private String path;

	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String password = request.getParameter("password");
		
		// 페이지 나누기 후
		String page = request.getParameter("page");
		String amount = request.getParameter("amount");
		String criteria = request.getParameter("criteria");
		String keyword = URLEncoder.encode(request.getParameter("keyword"), "utf-8");
		
		BoardRemoveService service = new BoardRemoveService();
		boolean removeFlag = service.remove(bno, password);
		
		if (!removeFlag) {
			path = "/view/qna_board_pwdCheck.jsp?page="+page+"&amount="+amount+"&criteria="+criteria+"&keyword="+keyword+"&bno="+bno;
		} else {
			path += "?page="+page+"&amount="+amount+"&criteria="+criteria+"&keyword="+keyword;
		}
		
		return new BoardActionForward(path, true);
	}

}
