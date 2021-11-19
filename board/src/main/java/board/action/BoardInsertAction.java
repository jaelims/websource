package board.action;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.service.BoardInsertService;
import board.util.UploadUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardInsertAction implements BoardAction {
	
	private String path;

	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		// request를 UploadUtil에 넘기기
		UploadUtil uploadUtil = new UploadUtil();
		Map<String, String> map = uploadUtil.requestParse(request);
			
		// map에서 값 가져오기
		BoardDTO insertDto = new BoardDTO();
		insertDto.setName(map.get("name"));
		insertDto.setTitle(map.get("title"));
		insertDto.setContent(map.get("content"));
		insertDto.setPassword(map.get("password"));
		// 파일첨부
		insertDto.setAttach(map.get("attach"));
		
		// 페이지 나누기 후 추가
		String page = map.get("page");
		String amount = map.get("amount");
		String criteria = map.get("criteria");
		String keyword = URLEncoder.encode(map.get("keyword"), "utf-8");
		
		// 서비스에게 작업 요청
		BoardInsertService service = new BoardInsertService();
		boolean insertFlag = service.boardInsert(insertDto);
		// 결과에 따라 이동
		if(!insertFlag) {
			path = "/view/qna_board_write.jsp";
			path += "?page="+page+"&amount="+amount+"&criteria="+criteria+"&keyword="+keyword;
		} else {
			path += "?page="+page+"&amount="+amount+"&criteria="+criteria+"&keyword="+keyword;
		}
			
		return new BoardActionForward(path, true);
	}

}
