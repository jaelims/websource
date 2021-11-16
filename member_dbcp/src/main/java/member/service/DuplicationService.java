package member.service;

import static member.persistence.JdbcUtil.*;

import java.sql.Connection;

import member.persistence.MemberDAO;

public class DuplicationService {
	public boolean dupId(String userid) {
		Connection con =getConnection();
		MemberDAO dao = new MemberDAO(con);
		boolean dupFlag = dao.idCheck(userid);
		
		close(con);
		
		return dupFlag; // true(아이디 사용가능), false(아이디 사용불가)
		
	}
}
