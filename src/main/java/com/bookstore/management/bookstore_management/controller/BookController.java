package com.bookstore.management.bookstore_management.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.management.bookstore_management.dto.BookDto;
import com.bookstore.management.bookstore_management.dto.DeleteResponse;
import com.bookstore.management.bookstore_management.exception.RunTimeException;
import com.bookstore.management.bookstore_management.service.BookService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/create/new")
	public ResponseEntity<BookDto> createNewBook(@RequestBody @Valid BookDto bookDto,@RequestParam Long authorId) throws RunTimeException {
		log.info("createNewBook API called.");
		BookDto registeredBook = bookService.createNewBook(bookDto,authorId);
		return new ResponseEntity<BookDto>(registeredBook, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<BookDto> updateBookDetails(@RequestBody @Valid BookDto bookDto, @PathVariable Long id) {
		log.info("updateBookDetails API called.");
		BookDto updatedBookDetails = bookService.updateBookDetails(bookDto, id);
		return new ResponseEntity<BookDto>(updatedBookDetails, HttpStatus.OK);
	}

	@GetMapping("/list/view")
	public ResponseEntity<List<BookDto>> getAllBooks() {
		log.info("getAllBooks API called.");
		List<BookDto> getBookList = bookService.getAllBooks();
		return new ResponseEntity<List<BookDto>>(getBookList, HttpStatus.OK);

	}

	@GetMapping("/id/{id}")
	public ResponseEntity<BookDto> getBook(@PathVariable Long id) {
		log.info("getBook API called.");
		BookDto getOneBook = bookService.getBook(id);
		return new ResponseEntity<BookDto>(getOneBook, HttpStatus.OK);
	}

	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<DeleteResponse> deleteBook(@PathVariable Long id) {
		log.info("deleteBook API called.");
		DeleteResponse deleteResponse = bookService.deleteBook(id);
		return new ResponseEntity<DeleteResponse>(deleteResponse, HttpStatus.OK);
	}

	@PatchMapping("/update/partial/{id}")
	public ResponseEntity<BookDto> updateBookDetailsPartially(@RequestBody @Valid Map<String, Object> updates,
			@PathVariable Long id) {
		log.info("updateBookDetailsPartially API called.");
		BookDto updatedBookDetails = bookService.updateBookDetailsPartially(updates, id);
		return new ResponseEntity<BookDto>(updatedBookDetails, HttpStatus.OK);
	}

}
