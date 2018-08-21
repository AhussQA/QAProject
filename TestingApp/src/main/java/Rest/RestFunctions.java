package Rest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import Database.Connection;
import Database.DatabaseFunctions;

@Path("/rest")
public class RestFunctions {

	@GET
	@Produces("Application/json")
	@Path("/search")
	public String searchForItem(@QueryParam("srstring") String search) {
		Connection singleton = new Connection();
		java.sql.Connection sqlConnection = singleton.getDatabaseConnection();
		String sql = DatabaseFunctions.listItems(search);
		String result = "Reached";
		int id=0;
		String name ="";
		int categoryID=0;
		String price ="";
		int quantity=0;
		int sellerID=0;
		
		try {
			result+=" try";
			Statement stmt = sqlConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
			name += rs.getString("Name");
			price += rs.getString("Price");
			id = rs.getInt("id");
			quantity = rs.getInt("Quantity");
			sellerID = rs.getInt("SellerID");
			categoryID = rs.getInt("CategoryID");
			result = "{\"id\":\""+id+"\""+","+ "\"name\":\""+name+"\""+"}";
			Map<String,String> item = new HashMap<>();
			item.put("id", String.valueOf(id));
			item.put("name", name);
			item.put("category", String.valueOf(categoryID));
			item.put("price", price);
			item.put("quantity", String.valueOf(quantity));
			item.put("sellerID", String.valueOf(sellerID));
			JSONObject json = new JSONObject(item);
			result = json.toString();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result += "Error";
		}
		return result;
	}
	
//	public String  search() {
//			
//	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/createUser")
//	public void createUser(Person p) {
		public void createUser(@FormParam("firstname") String fname, @FormParam("lastname") String lname, @FormParam("username") String username,
				@FormParam("password") String password, @FormParam("email") String email, @FormParam("doornumber") int doornumber, 
				@FormParam("street") String street, @FormParam("postcode") String postcode) {
//		System.out.println(p.toString());
		System.out.println(fname);
		System.out.println("Start");
		Connection singleton = new Connection();
		java.sql.Connection sqlConnection = singleton.getDatabaseConnection();
//		String personSql = DatabaseFunctions.createUserAccount(1, username, password,
//				fname, lname,doornumber,postcode);
		String sqlPostcode = DatabaseFunctions.createPostCode(postcode, street,"manchester", "uk");
		String sqlPostcodeCheck = DatabaseFunctions.listPostcode(postcode);
		String result = "Reached";
		try {
			System.out.println("tryBlock");

			Statement stmt = sqlConnection.createStatement();
		
			ResultSet rs = stmt.executeQuery(sqlPostcodeCheck);
			if(!rs.next() || rs == null) {
			stmt.executeUpdate(sqlPostcode);
			}
			
			ResultSet maxPeople = stmt.executeQuery(DatabaseFunctions.getMaxPersonID());
			
			 maxPeople.first();
			int personId = maxPeople.getInt("max")+1;
//			System.out.println("maxperson:: "+personId);
			
			String personSql = DatabaseFunctions.createUserAccount(personId, username, password,
					fname, lname,doornumber,postcode);

			stmt.executeUpdate(personSql);
			System.out.println("tryBlock");
		}
		catch(SQLException e) {
			System.out.println("catchBlock");

			e.printStackTrace();
		}
		
	}
}
