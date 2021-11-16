package member.service;

import static member.persistence.JdbcUtil.*;

import java.sql.Connection;

import member.domain.MemberDTO;
import member.persistence.MemberDAO;

public class JoinService {
	public boolean register(MemberDTO memberDto) {
		
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		boolean joinFlag = dao.insert(memberDto);
		
		if (joinFlag) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return joinFlag;
	}
	
}
