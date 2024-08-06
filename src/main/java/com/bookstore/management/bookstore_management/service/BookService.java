package com.bookstore.management.bookstore_management.service;

import java.util.List;
import java.util.Map;

import com.bookstore.management.bookstore_management.dto.BookDto;
import com.bookstore.management.bookstore_management.dto.DeleteResponse;
import com.bookstore.management.bookstore_management.exception.RunTimeException;

public interface BookService {

	BookDto createNewBook(BookDto bookDto,Long authorId) throws RunTimeException;

	BookDto updateBookDetails(BookDto bookDto, Long id);

	List<BookDto> getAllBooks();

	BookDto getBook(Long id);

	DeleteResponse deleteBook(Long id);

	BookDto updateBookDetailsPartially(Map<String, Object> updates, Long id);

	

}
