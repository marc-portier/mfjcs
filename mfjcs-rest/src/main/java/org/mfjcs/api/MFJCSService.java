package org.mfjcs.api;

public interface MFJCSService {

	Item getItem(String uuid) throws IndexOperationFailedException;

	Item createNewItem(CreateItemRequest createItemRequest) throws IndexOperationFailedException;

}
