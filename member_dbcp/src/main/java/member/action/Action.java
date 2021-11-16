package member.action;

import javax.servlet.http.HttpServletRequest;

// Action 클래스가 동일한 형태를 갖추기 위해서 사용

public interface Action {
	public ActionForward execute(HttpServletRequest request) throws Exception;
}
