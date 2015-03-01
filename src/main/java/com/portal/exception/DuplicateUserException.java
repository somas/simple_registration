package com.portal.exception;

public class DuplicateUserException extends RuntimeException {

	private static final long serialVersionUID = 8293340772491711621L;

	public DuplicateUserException(Throwable e) {
        super(e);
    }

    public DuplicateUserException(String msg) {
        super(msg);
    }

    public DuplicateUserException(String msg, Throwable e) {
        super(msg, e);
    }
}