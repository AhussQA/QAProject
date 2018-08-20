package Rest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.json.JSONML;
import org.json.JSONObject;
import org.json.JSONString;

import com.mysql.cj.xdevapi.JsonString;

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
}
