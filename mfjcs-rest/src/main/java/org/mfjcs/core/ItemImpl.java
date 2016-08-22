package org.mfjcs.core;

import java.util.Map;

import org.mfjcs.api.Item;

public class ItemImpl implements Item {

	private String uuid;

	private Long version;

	private Map<String, Object> fields;

	public ItemImpl(String uuid, Long version, Map<String, Object> fields) {
		this.uuid = uuid;
		this.version = version;
		this.fields = fields;
	}

	public String getUuid() {
		return uuid;
	}

	public Long getVersion() {
		return version;
	}

	public Map<String, Object> getFields() {
		return fields;
	}
}
