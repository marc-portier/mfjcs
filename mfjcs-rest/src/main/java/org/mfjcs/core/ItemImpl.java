package org.mfjcs.core;

import java.util.Map;

import org.mfjcs.api.Item;
import org.mfjcs.api.ItemMetadata;

public class ItemImpl implements Item {

	private ItemMetadata itemMetadata;

	private Map<String, Object> fields;

	public ItemImpl(ItemMetadata itemMetadata, Map<String, Object> fields) {
		this.itemMetadata = itemMetadata;
		this.fields = fields;
	}

	public ItemMetadata getMetadata() {
		return itemMetadata;
	}

	public Map<String, Object> getFields() {
		return fields;
	}
}
