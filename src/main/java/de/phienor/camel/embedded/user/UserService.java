package de.phienor.camel.embedded.user;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * @author Philipp Koch (created), $Date$
 * @author $Author$ (last changed)
 * @version $Rev$, $Date$<br>
 *          $Id: $
 */
@Path("/user")
public class UserService {

    @Produce(uri = AsynchronousUserWorker.JMS_QUEUE_STORE_USER)
    ProducerTemplate storeUserQueue;

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/")
    public Response storeUser(User user){
        storeUserQueue.sendBody(user);
        return Response.ok().entity(user).build();
    }

    @GET
    @Produces("application/json")
    public User getUser(){
        User user = new User();
        user.setCity("Köln");
        user.setFirstName("Philipp");
        user.setLastName("Koch");
        user.setStreet("Josef-Schumpeter-Allee 1");
        return user;
    }

}
