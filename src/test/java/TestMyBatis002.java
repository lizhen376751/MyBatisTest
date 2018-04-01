import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestMyBatis002 {

	public static void main(String[] args) {
		try {
//			String username = "  or 1=1 ";
//			String password = " 644";
//			String sql = "SELECT id,username FROM user_table WHERE " + "username='" + username + "'AND " + "password='"
//					+ password + "'";

			 String sql = "SELECT id,name FROM users WHERE name=? AND age=?";
			System.out.println("sql:" + sql);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://192.168.52.128:3306/test", "lizhen", "admin");
			PreparedStatement stat = con.prepareStatement(sql);
			 stat.setString(1, "Tom");
			 stat.setString(2, "12");
			System.out.println(stat.toString());
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				System.out.println("id:" + id + "---name:" + name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
