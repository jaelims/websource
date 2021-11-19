package board.action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.domain.PageDTO;
import board.domain.SearchDTO;
import board.service.BoardReplyService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardReplyAction implements BoardAction {

	private String path;
	
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		
		BoardDTO dto = new BoardDTO();
		// 댓글에 대한 정보
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		// 원본글에 대한 정보
		dto.setRe_ref(Integer.parseInt(request.getParameter("re_ref")));
		dto.setRe_seq(Integer.parseInt(request.getParameter("re_seq")));
		dto.setRe_lev(Integer.parseInt(request.getParameter("re_lev")));
		
		// 페이지 나누기 후 추가
		String bno = request.getParameter("bno");
		String page = request.getParameter("page");
		String amount = request.getParameter("amount");
		String criteria = request.getParameter("criteria");
		String keyword = URLEncoder.encode(request.getParameter("keyword"), "utf-8");
		
		BoardReplyService service = new BoardReplyService();
		boolean insertFlag = service.reply(dto);
		
		if (!insertFlag) {
			path = "/read.do?page="+page+"&amount="+amount+"&criteria="+criteria+"&keyword="+keyword+"bno="+bno;
		} else {
			path += "?page="+page+"&amount="+amount+"&criteria="+criteria+"&keyword="+keyword;
		}
		
		return new BoardActionForward(path, true);
	}

}
