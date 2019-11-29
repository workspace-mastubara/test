import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class TestUserDAO {
	private String name;
	private String password;

	public void select (String name, String password) {
		DBConnector2 db = new  DBConnector2();
		Connection con = db.getConnect();

		String sql = "select * from test_table where user_name=? and password=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, this.name);
				ps.setString(1, this.password);
				ResultSet rs = ps.executeQuery();
			if(rs.next()){
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}


}