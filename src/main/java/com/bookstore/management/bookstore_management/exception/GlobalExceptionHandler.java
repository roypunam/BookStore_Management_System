package com.bookstore.management.bookstore_management.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bookstore.management.bookstore_management.dto.ExceptionResponse;
import com.bookstore.management.bookstore_management.utils.StringUtils;

/**
 * <b>Global Exception Handler</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> ExceptionHandler(Exception ex) {
		String message = ex.getMessage();
		ExceptionResponse response = new ExceptionResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				StringUtils.INTERNAL_SERVER_ERROR, message);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AuthorNotFoundException.class)
	public ResponseEntity<ExceptionResponse> AuthorNotFoundExceptionHandler(AuthorNotFoundException ex) {
		String message = ex.getMessage();
		ExceptionResponse response = new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(),
				StringUtils.AUTHOR_NOT_FOUND, message);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> methodArgumentNotValidExceptionHandler(
			MethodArgumentNotValidException ex) {
		String message = ex.getMessage();
		ExceptionResponse response = new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(),
				StringUtils.METHOD_ARGUMENT_NOT_VALID_EXCEPTION, message);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ExceptionResponse> BookNotFoundExceptionHandler(BookNotFoundException ex) {
		String message = ex.getMessage();
		ExceptionResponse response = new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(),
				StringUtils.BOOK_NOT_FOUND, message);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

}
