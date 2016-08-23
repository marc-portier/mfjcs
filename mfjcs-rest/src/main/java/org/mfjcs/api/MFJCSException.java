package org.mfjcs.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class MFJCSException extends Exception {

	public MFJCSException(Throwable cause) {
		super(cause);
	}

	@JsonProperty
	public abstract String getErrorCode();

	@JsonProperty
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public Object[] getParams() {
		return null;
	}

}
