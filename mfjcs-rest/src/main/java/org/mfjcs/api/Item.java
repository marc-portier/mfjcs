package org.mfjcs.api;

import java.util.Map;

public interface Item {

	String getUuid();

	Long getVersion();

	Map<String, Object> getFields();

}
