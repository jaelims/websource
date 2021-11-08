package book.controller;

import book.action.BookAction;
import book.action.BookDeleteAction;
import book.action.BookInsertAction;
import book.action.BookListAction;
import book.action.BookModifyAction;
import book.action.BookSearchAction;

public class BookActionFactory {
	private static BookActionFactory bookActionFactory = null;
	private BookAction action;
	
	private BookActionFactory() {}
	
	public static BookActionFactory getInstance() {
		if(bookActionFactory == null) {
			bookActionFactory = new BookActionFactory();
		}
		return bookActionFactory;	
	}
	
	public BookAction action(String cmd) {
		if(cmd.equals("/list.do")) {
			action = new BookListAction("/selectIndex.jsp");
		} else if(cmd.equals("/insert.do")) {
			action = new BookInsertAction("/list.do");
		} else if(cmd.equals("/modify.do")) {
			action = new BookModifyAction("/list.do");
		} else if(cmd.equals("/delete.do")) {
			action = new BookDeleteAction("/list.do");
		} else if(cmd.equals("/search.do")) {
			action = new BookSearchAction("/searchIndex.jsp");
		}
		
		return action;
	}
}
