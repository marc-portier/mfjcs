package org.mfjcs.resources;

import java.util.Map;

import org.mfjcs.api.CreateItemRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateItemRequestFromJsonAdapter implements CreateItemRequest {

	@JsonProperty
	private Map<String, Object> fields;

	@Override
	public Map<String, Object> getFields() {
		return fields;
	}
}
