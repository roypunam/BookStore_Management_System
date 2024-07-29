package com.bookstore.management.bookstore_management.exception;

public class AuthorExistException extends Exception{

	private static final long serialVersionUID = -1867669419723037513L;

	public AuthorExistException(String errorMessage) {
		super(errorMessage);
	}
}
