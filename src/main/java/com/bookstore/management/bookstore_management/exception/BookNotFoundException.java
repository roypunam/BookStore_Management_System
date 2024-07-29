package com.bookstore.management.bookstore_management.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * <b>Book Not Found Exception</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@Getter
@Setter
public class BookNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -5063697235277892701L;

	public BookNotFoundException(String entityName, String fieldName, Long fieldValue) {
		super(String.format("%s not found with %s: %s", entityName, fieldName, fieldValue));
	}
}