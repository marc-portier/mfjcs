package org.mfjcs.api;

public class IndexOperationFailedException extends MFJCSException {
	public IndexOperationFailedException(Throwable cause) {
		super(cause);
	}

	@Override
	public String getErrorCode() {
		return "error.internal.index.operation.failed";
	}
}
