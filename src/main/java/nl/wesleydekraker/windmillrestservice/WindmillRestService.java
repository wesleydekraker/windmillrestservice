package nl.wesleydekraker.windmillrestservice;


import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

@Path("/windmills")
public class WindmillRestService {
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response readAll() {
	    WindmillServiceImpl windmillServiceImpl = ServiceProvider.getWindmillService();

	    List<Windmill> windmills = windmillServiceImpl.readAll();
        return Response.ok(new GenericEntity<List<Windmill>>(windmills){}).build();
	}

	@GET
	@Path("/{id}")
    @Produces ({MediaType.APPLICATION_JSON})
	public Response read(@PathParam("id") int id) {
		WindmillServiceImpl windmillServiceImpl = ServiceProvider.getWindmillService();
		Windmill windmill = windmillServiceImpl.read(id);

        if (windmill != null) {
            return Response.ok(windmill).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces ({MediaType.APPLICATION_JSON})
	public Response create(Windmill windmill){
		WindmillServiceImpl windmillServiceImpl = ServiceProvider.getWindmillService();
        windmill = windmillServiceImpl.create(windmill);

        return Response.ok(windmill).build();
	}

    @PUT
    @Consumes ({MediaType.APPLICATION_JSON})
    @Produces ({MediaType.APPLICATION_JSON})
    public Response update(Windmill windmill){
        WindmillServiceImpl windmillServiceImpl = ServiceProvider.getWindmillService();

        if (windmillServiceImpl.update(windmill)) {
            return Response.ok(windmill).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id){
        WindmillServiceImpl windmillServiceImpl = ServiceProvider.getWindmillService();

        if (windmillServiceImpl.delete(id)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
