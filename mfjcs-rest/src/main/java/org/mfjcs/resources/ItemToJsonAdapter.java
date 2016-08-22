package org.mfjcs.resources;

import java.util.Map;

import org.mfjcs.api.Item;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemToJsonAdapter {

	private Item item;

	public ItemToJsonAdapter(Item item) {
		this.item = item;
	}

	@JsonProperty
	public String getUuid() {
		return item.getUuid();
	}

	@JsonProperty
	public Long getVersion() { return item.getVersion(); }

	@JsonProperty
	public Map<String, Object> getFields() {
		return item.getFields();
	}
}
