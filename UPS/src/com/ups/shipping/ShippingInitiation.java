package com.ups.shipping;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
	
	@POST
	@Path("/start")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject initiateShipping(JsonObject incoming) {
		
		String organization = incoming.getString("Organization");
		String orderRefId = incoming.getString("OrderRefId");
		int numberOfItemsToShip = incoming.getInt("ItemsNumber");
		String zip = incoming.getString("Zip");
		
		JsonObject response = Json.createObjectBuilder()
								.add("Accepted", true)
								.add("ShippingReferenceNumber", 1005)
								.add("Organization", organization)
								.add("OrderRefId", orderRefId)
								.build();

	
		return response;	
	}
}
