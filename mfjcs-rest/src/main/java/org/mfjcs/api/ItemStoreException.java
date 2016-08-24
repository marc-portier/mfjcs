package org.mfjcs.api;

public class ItemStoreException extends MFJCSException {
	public ItemStoreException(Throwable e) {
		super(e);
	}

	@Override
	public String getErrorCode() {
		return "error.internal.item.store.failed";
	}
}
