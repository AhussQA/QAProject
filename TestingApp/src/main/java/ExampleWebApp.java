import java.sql.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/web")
public class ExampleWebApp {
	
	
	@GET
	@Produces("Application/json")
	@Path("/hello")
	public String sayHello() {
		String DB_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";

		String USER = "root";
		String PASS = "1234";
		String finalValue = "";
			try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
					Statement stmt = conn.createStatement();) {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				String sql = "select * FROM item LIMIT 1";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					finalValue = rs.getString("Name");
				}
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "{\"result\":\""+finalValue +"\"}";
	}
	
	@GET
	@Produces("Application/json")
	@Path("/hi")
	public String sayHi(){
		String DB_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";

		String USER = "root";
		String PASS = "1234";
		String finalValue = "";
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();) {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String sql = "select * FROM item";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				finalValue += rs.getString("Name");
			}
			rs.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"result\":\""+finalValue +"\"}";
	}
	
}
