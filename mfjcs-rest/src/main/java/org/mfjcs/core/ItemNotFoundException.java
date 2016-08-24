package org.mfjcs.core;

public class ItemNotFoundException extends Exception {
	public ItemNotFoundException(String id) {
		super("Item with id " + id + " not found");
	}
}
