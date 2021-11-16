package member.action;

import javax.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;
import member.domain.MemberDTO;
import member.service.JoinService;

@AllArgsConstructor
public class JoinAction implements Action {

	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		
		// joinForm.jsp에서 넘긴 값 가져오기
		MemberDTO memberDto = new MemberDTO();
		memberDto.setUserid(request.getParameter("userid"));
		memberDto.setPassword(request.getParameter("password"));
		memberDto.setName(request.getParameter("name"));
		memberDto.setGender(request.getParameter("gender"));
		memberDto.setEmail(request.getParameter("email"));
		
		// db 작업 요청
		JoinService service = new JoinService();
		boolean joinFlag = service.register(memberDto);
		
		// 결과에 따라 페이지 이동(실패시 joinForm.jsp)
		if(!joinFlag) {
			path = "/view/joinForm.jsp";
		}
		
		return new ActionForward(path, true);
	}

}
