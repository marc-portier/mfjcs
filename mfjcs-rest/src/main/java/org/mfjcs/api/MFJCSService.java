package org.mfjcs.api;

import org.mfjcs.core.ItemNotFoundException;

public interface MFJCSService {

	Item getItem(String uuid) throws IndexOperationFailedException, ItemNotFoundException;

	Item createNewItem(CreateItemRequest createItemRequest) throws IndexOperationFailedException, ItemStoreException;

}
