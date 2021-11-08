package pattern.controller;

import pattern.action.Action;
import pattern.action.LoginAction;

public class ActionFactory {
	
	// 객체 생성을 하나만 하는 방식(singleton 패턴)
	private static ActionFactory af;
	
	private ActionFactory() {}
	public static ActionFactory getInstance() {
		if (af == null) {
			af = new ActionFactory();
		}
		return af;
	}
	
	Action action = null;
	
	public Action action(String cmd) {
		
		// action 작업이 성공하면 움직일 페이지 기록
		if(cmd.equals("/login.do")) {
			action = new LoginAction("/index.jsp");
		} else if (cmd.equals("/update.do")) {
			
		} else if (cmd.equals("/index.do")) {
			
		}
		
		return action;
	}
}
