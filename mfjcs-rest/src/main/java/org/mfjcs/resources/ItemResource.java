package org.mfjcs.resources;

import static java.util.UUID.randomUUID;

import java.util.Collections;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.mfjcs.api.Item;

@Path("items")
public class ItemResource {

	@Path("{uuid}")
	@GET
	@Produces("application/json")
	public ItemToJsonAdapter getItem(@PathParam("uuid") String uuid) {
		return new ItemToJsonAdapter(new Item() {
			@Override
			public String getUuid() {
				return randomUUID().toString();
			}

			@Override
			public Long getVersion() {
				return 1L;
			}

			@Override
			public Map<String, Object> getFields() {
				return Collections.singletonMap("name", "example");
			}
		});
	}
}
