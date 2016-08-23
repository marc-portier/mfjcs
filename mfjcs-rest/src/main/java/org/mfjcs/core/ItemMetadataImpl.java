package org.mfjcs.core;

import org.mfjcs.api.ItemMetadata;

public class ItemMetadataImpl implements ItemMetadata {

	private String id;
	private Long version;
	private String author;

	public ItemMetadataImpl(String id, Long version, String author) {
		this.id = id;
		this.version = version;
		this.author = author;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public Long getVersion() {
		return version;
	}

	@Override
	public String getAuthor() {
		return author;
	}
}
