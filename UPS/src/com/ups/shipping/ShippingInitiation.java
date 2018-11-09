package com.ups.shipping;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/initiation")
public class ShippingInitiation {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response ping() {
		return Response.ok("UPS is up and willing to serve you").build();	
	}
}
