package com.bookstore.management.bookstore_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.management.bookstore_management.dto.BookDto;
import com.bookstore.management.bookstore_management.dto.DeleteResponse;
import com.bookstore.management.bookstore_management.entity.AuthorEntity;
import com.bookstore.management.bookstore_management.entity.BookEntity;
import com.bookstore.management.bookstore_management.exception.BookNotFoundException;
import com.bookstore.management.bookstore_management.exception.RunTimeException;
import com.bookstore.management.bookstore_management.repository.AuthorRepository;
import com.bookstore.management.bookstore_management.repository.BookRepository;
import com.bookstore.management.bookstore_management.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private AuthorRepository authorRepo;

	@Override
	public BookDto createNewBook(BookDto bookDto, Long authorId) throws RunTimeException {
		log.info("createNewBook service impl called.");
		AuthorEntity author = authorRepo.findById(authorId).orElseThrow(() -> new RunTimeException("Author not found"));
		// DTO to BookEntity conversion
		BookEntity book = BookDto.getBook(bookDto);
		book.setAuthor(author);
		BookEntity savedBook = bookRepo.save(book);
		return BookEntity.getBookDto(savedBook);

	}

	@Override
	public BookDto updateBookDetails(BookDto bookDto, Long id) {
		log.info("updateBookDetails service impl called.");

		// Database called

		BookEntity book = bookRepo.findById(id)
				.orElseThrow(() -> new BookNotFoundException("BookEntity", "bookId", id));
		book.setTitle(bookDto.getTitle());
		book.setIsbn(bookDto.getIsbn());

		// Update details saved
		BookEntity updatedBook = bookRepo.save(book);
		BookDto response = BookEntity.getBookDto(updatedBook);
		return response;
	}

	@Override
	public List<BookDto> getAllBooks() {
		log.info("getAllBooks service impl called.");

		// Database called
		List<BookEntity> bookList = bookRepo.findAll();

		// BookEntity to DTO conversion
		List<BookDto> response = new ArrayList<>();
		for (BookEntity getBook : bookList) {
			BookDto dto = BookEntity.getBookDto(getBook);
			response.add(dto);
		}
		return response;

	}

	@Override
	public BookDto getBook(Long id) {
		log.info("getBook service impl called.");

		// Database called
		BookEntity book = bookRepo.findById(id)
				.orElseThrow(() -> new BookNotFoundException("BookEntity", "bookId", id));

		// BookEntity to DTO conversion
		BookDto response = BookEntity.getBookDto(book);
		return response;
	}

	@Override
	public DeleteResponse deleteBook(Long id) {
		log.info("deleteBook service impl called.");

		// Database called to find book
		BookEntity book = bookRepo.findById(id)
				.orElseThrow(() -> new BookNotFoundException("BookEntity", "bookId", id));

		// Database called to delete book
		bookRepo.delete(book);
		return new DeleteResponse("Record of the book deleted successfully", true);
	}

	@Override
	public BookDto updateBookDetailsPartially(Map<String, Object> updates, Long id) {
		Optional<BookEntity> bookOptional = bookRepo.findById(id);

		if (bookOptional.isPresent()) {
			BookEntity book = bookOptional.get();
			updates.forEach((key, value) -> {
				switch (key) {
				case "title":
					book.setTitle((String) value);
					break;
				case "isbn":
					book.setIsbn((String) value);
					break;

				}
			});
			BookEntity books = bookRepo.save(book);
			return BookEntity.getBookDto(books);
		} else {
			throw new RuntimeException("Book not found with id " + id);
		}
	}
}
