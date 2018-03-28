package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.login;
public class loginDao {
	public static login check(final String username,String password) throws Exception {
		JDBCTemplate<login> q = new Query<login>() {
			@Override
			protected login doQuery(Connection conn) throws Exception {
				PreparedStatement ps = conn
						.prepareStatement("select * from login where username=? and password=?");
				ps.setString(1, username);
				ps.setString(2, password);
				ps.execute();
				ResultSet rs = ps.getResultSet();
				login log = null;
				if (rs.next()) {
					log = new login();
					log.id = rs.getInt("id");
					log.username = rs.getString("username");
					log.password = rs.getString("password");
					log.name = rs.getString("name");
				}
				else {
					log = new login();
					log.id = -1;
					log.username = null;
					log.password = null;
					log.name = null;
				}
				return log;
			}
		};
		return q.execute();
	}
}
