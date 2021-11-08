package pattern.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pattern.domain.MemberDTO;
import pattern.service.LoginService;

@AllArgsConstructor
@Getter
public class LoginAction implements Action {
	
	private String path; // /index.jsp

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		// 사용자가 넘기는 값 가져오기
//		String no = request.getParameter("no");
//		System.out.println("no "+no);
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		// 서비스 작업
		LoginService service = new LoginService();
		MemberDTO loginDto = service.loginService(userid, password);
		
		// 결과에 따라서 ActionForward 객체 생성
		if(loginDto == null) { // 로그인 실패
			path = "/view/login.jsp"; // 로그인 폼 보여주기
		} else { // 로그인 성공 => 세션에 값 담기
			HttpSession session = request.getSession();
			session.setAttribute("loginDto", loginDto);
		}
		
		// 로그인 실패 new ActionForward("/view/login.jsp", true);
		// 로그인 성공 new ActionForward("/index.jsp", true);
		
		return new ActionForward(path, true);
	}

}
