package board.action;

// 사용자의 요청에 따라 Action 생성

public class BoardActionFactory {
	private static BoardActionFactory baf;
	private BoardAction action;
	
	private BoardActionFactory() {}
	public static BoardActionFactory getInstance() {
		if (baf == null) {
			baf = new BoardActionFactory();
		}
		return baf;
	}
	
	public BoardAction action(String cmd) {
		if (cmd.equals("/insert.do")) {
			action = new BoardInsertAction("/list.do");
		} else if (cmd.equals("/list.do")) {
			action = new BoardListAction("/view/qna_board_list.jsp");
		} else if (cmd.equals("/read.do")) {
			action = new BoardReadAction("/view/qna_board_view.jsp");
		} else if (cmd.equals("/countUpdate.do")) {
			action = new BoardCountUpdateAction("/read.do");
		} else if (cmd.equals("/remove.do")) {
			action = new BoardRemoveAction("/list.do");
		} else if (cmd.equals("/modify.do")) {
			action = new BoardReadAction("/view/qna_board_modify.jsp");
		} else if (cmd.equals("/update.do")) {
			action = new BoardUpdateAction("/read.do");
		} else if (cmd.equals("/replyView.do")) {
			action = new BoardReadAction("/view/qna_board_reply.jsp");
		} else if (cmd.equals("/reply.do")) {
			action = new BoardReplyAction("/list.do");
		}
//		} else if (cmd.equals("/search.do")) {
//			action = new BoardListAction("/view/qna_board_list.jsp");
//		}
		return action;
	}
}
