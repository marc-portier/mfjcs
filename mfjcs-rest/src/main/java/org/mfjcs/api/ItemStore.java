package org.mfjcs.api;

public interface ItemStore {

	public Item save(Item item) throws ItemStoreException;

}
