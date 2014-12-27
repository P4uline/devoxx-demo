package fr.devoxx.demo.aggreg;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/music")
public class MusicResource {

	// curl -v http://localhost:8080/demo-mongo-aggreg/rest/music/ping
	@Path("/ping")
	@GET
	public Response ping() {
		String okMEssage = "C'est bon, c'est ok";
		return Response.status(200).entity(okMEssage).build();
	}
}
