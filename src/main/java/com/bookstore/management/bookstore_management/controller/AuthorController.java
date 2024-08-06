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
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.management.bookstore_management.dto.AuthorDto;
import com.bookstore.management.bookstore_management.dto.DeleteResponse;
import com.bookstore.management.bookstore_management.service.AuthorService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/author")
@Slf4j
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@PostMapping("/create")
	public ResponseEntity<AuthorDto> createAuthor(@RequestBody @Valid AuthorDto authorDto) {
		log.info("createAuthor API called.");

		AuthorDto registeredAuthor = authorService.createAuthor(authorDto);
		return new ResponseEntity<AuthorDto>(registeredAuthor, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<AuthorDto> updateAuthorDetails(@RequestBody @Valid AuthorDto authorDto, @PathVariable Long id) {
		log.info("updateAuthorDetails API called.");
		AuthorDto updatedDetails = authorService.updateAuthorDetails(authorDto, id);
		return new ResponseEntity<AuthorDto>(updatedDetails, HttpStatus.OK);
	}

	@GetMapping("/list/view")
	public ResponseEntity<List<AuthorDto>> getAllAuthor() {
		log.info("getAllAuthor API called.");
		List<AuthorDto> getAuthorList = authorService.getAllAuthor();
		return new ResponseEntity<List<AuthorDto>>(getAuthorList, HttpStatus.OK);

	}

	@GetMapping("view/id/{id}")
	public ResponseEntity<AuthorDto> getAuthor(@PathVariable Long id) {
		log.info("getAuthor API called.");
		AuthorDto getAuthor = authorService.getAuthor(id);
		return new ResponseEntity<AuthorDto>(getAuthor, HttpStatus.OK);
	}

	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<DeleteResponse> deleteAuthor(@PathVariable Long id) {
		log.info("deleteAuthor API called.");
		DeleteResponse deleteResponse = authorService.deleteAuthor(id);
		return new ResponseEntity<DeleteResponse>(deleteResponse, HttpStatus.OK);
	}

	@PatchMapping("/update/partial/{id}")
	public ResponseEntity<AuthorDto> updateAuthorDetailsPartially(@RequestBody @Valid Map<String, Object> updates,
			@PathVariable Long id) {
		log.info("updateAuthorDetailsPartially API called.");
		AuthorDto updatedauthorDetails = authorService.updateAuthorDetailsPartially(updates, id);
		return new ResponseEntity<AuthorDto>(updatedauthorDetails, HttpStatus.OK);
	}

}
