import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by tahirou on 17/11/2016.
 */

@Path("/greeting")
public interface GreetingController {

    @Path("/hello/{name}")
    String sayHello(@PathParam("name") final String name);
}
