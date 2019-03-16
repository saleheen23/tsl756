package in.lnt.TestNG;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.MyConnection;

public class LoginDataDaoImpl implements loginDataDao
{
	Connection conn=MyConnection.getMyConnection();

	@Override
	public List<DatabaseLoginPojo> getAllLoginDetails() {
		
		List<DatabaseLoginPojo> log_list = new ArrayList<DatabaseLoginPojo>();
		DatabaseLoginPojo log =null;

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from Login");
			while(rs.next()) {
				log= new DatabaseLoginPojo();
				log.setUsername(rs.getString(1));
				log.setPassword(rs.getString(2));
				log.setStatus(rs.getString(3));
				log_list.add(log);
				
				}
			}
		 catch (SQLException e) {
					e.printStackTrace();
		}
		
		return log_list;
	}
}
