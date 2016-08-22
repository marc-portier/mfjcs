package org.mfjcs.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.mfjcs.api.IndexOperationFailedException;
import org.mfjcs.api.MFJCSService;

@Path("items")
public class ItemResource {

	private MFJCSService mfjcsService;

	public ItemResource(MFJCSService mfjcsService) {
		this.mfjcsService = mfjcsService;
	}

	@Path("{uuid}")
	@GET
	@Produces("application/json")
	public ItemToJsonAdapter getItem(@PathParam("uuid") String uuid) throws IndexOperationFailedException {
		return new ItemToJsonAdapter(mfjcsService.getItem(uuid));
	}

	@POST
	@Consumes("application/json")
	public ItemToJsonAdapter createNewItem(CreateItemRequestFromJsonAdapter createItemRequest) throws IndexOperationFailedException {
		// TODO: add self link. Consider siren or hal?
		return new ItemToJsonAdapter(mfjcsService.createNewItem(createItemRequest));
	}
}
