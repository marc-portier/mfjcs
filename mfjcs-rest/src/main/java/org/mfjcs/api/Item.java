package org.mfjcs.api;

import java.util.Map;

public interface Item {

	ItemMetadata getMetadata();

	Map<String, Object> getFields();

}
