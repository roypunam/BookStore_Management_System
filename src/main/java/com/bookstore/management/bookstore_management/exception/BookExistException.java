package com.bookstore.management.bookstore_management.exception;

public class BookExistException extends Exception{

	private static final long serialVersionUID = -1867669419723037513L;

	public BookExistException(String errorMessage) {
		super(errorMessage);
	}
}
