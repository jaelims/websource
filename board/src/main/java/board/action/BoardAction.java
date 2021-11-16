package board.action;

import javax.servlet.http.HttpServletRequest;

public interface BoardAction {
	public BoardActionForward execute(HttpServletRequest request) throws Exception;
}
