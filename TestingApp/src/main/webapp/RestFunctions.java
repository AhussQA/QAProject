package Rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import main.Database.*;

@Path("/rest")
public class RestFunctions {

	@GET
	@Produces("Application/json")
	@Path("{search}")
	public String searchForItem(@PathParam("search") String search) {
	}
	
	public String  search() {
			
	}
}
