package de.phienor.camel.embedded;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * @author Philipp Koch (created), $Date$
 * @author $Author$ (last changed)
 * @version $Rev$, $Date$<br>
 *          $Id: $
 */
@Path("/events")
public class EventService {

    @Autowired
    private EventStore eventStore;

    @GET
    @Path("/")
    @Produces("application/json")
    public Response getAllEvents(){
        return Response.ok().entity(eventStore.getEventInformations()).build();
    }
}
