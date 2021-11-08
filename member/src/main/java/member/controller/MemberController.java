package member.controller;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.action.Action;
import member.action.ActionForward;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("utf-8");
		
		// 요청 파악 : URI 분리
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = requestUri.substring(contextPath.length());
		
		// Uri에 따라 액션 생성
		MemberActionFactory maf = MemberActionFactory.getInstance();
		Action action = maf.action(cmd);
		
		// 생성된 action 일 시키기
		ActionForward af = null;
		try {
			af=action.execute(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 결과에 따라 페이지 이동
		if (af.isRedirect()) {
			response.sendRedirect(af.getPath());
		} else {
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
