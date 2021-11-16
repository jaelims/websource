package member.service;

import java.sql.Connection;
import static member.persistence.JdbcUtil.*;

import member.domain.UpdateDTO;
import member.persistence.MemberDAO;

public class ModifyService {
	public boolean modify(UpdateDTO updateDto) {
		
		Connection con = getConnection();
		MemberDAO dao =new MemberDAO(con);
		
		boolean modifyFlag = dao.update(updateDto);
		
		if(modifyFlag) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return modifyFlag;
	}
}
