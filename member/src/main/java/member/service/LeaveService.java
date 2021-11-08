package member.service;

import java.sql.Connection;

import member.domain.MemberDTO;
import member.persistence.MemberDAO;

import static member.persistence.JdbcUtil.*;

public class LeaveService {
	public boolean leave(String userid, String password) {
		
		Connection con = getConnection();
		MemberDAO dao =new MemberDAO(con);
		
		boolean leaveFlag = dao.isLeave(userid, password);
		
		if(leaveFlag) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return leaveFlag;
	}
}
