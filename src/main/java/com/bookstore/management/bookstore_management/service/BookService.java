package com.bookstore.management.bookstore_management.service;

import java.util.List;
import java.util.Map;

import com.bookstore.management.bookstore_management.dto.BookDto;
import com.bookstore.management.bookstore_management.dto.DeleteResponse;
import com.bookstore.management.bookstore_management.exception.RunTimeException;

public interface BookService {

	BookDto createNewBook(BookDto bookDto,Long authorId) throws RunTimeException;

	BookDto updateBookDetails(BookDto bookDto, Long id);
	
	BookDto updateBookDetailsPartially(Map<String, Object> fields, Long id);

	BookDto getBook(Long id);
	
	List<BookDto> getAllBooks();

	DeleteResponse deleteBook(Long id);

	

	

}
