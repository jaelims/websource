package board.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.service.BoardUpdateService;
import board.util.UploadUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardUpdateAction implements BoardAction {

	private String path;
	
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		
		UploadUtil uploadUtil = new UploadUtil();
		Map<String, String> map = uploadUtil.requestParse(request);
		
		BoardDTO dto = new BoardDTO();
		dto.setBno(Integer.parseInt(map.get("bno")));
		dto.setName(map.get("name"));
		dto.setTitle(map.get("title"));
		dto.setContent(map.get("content"));
		dto.setPassword(map.get("password"));
		dto.setAttach(map.get("attach"));
		
		BoardUpdateService service = new BoardUpdateService();
		boolean updateFlag = service.update(dto);
		
		if (updateFlag) {
			path += "?bno="+dto.getBno();
		} else {
			path = "/modify.do?bno="+dto.getBno();
		}
		
		return new BoardActionForward(path, true);
	}

}
