package com.bookstore.management.bookstore_management.service;

import java.util.List;
import java.util.Map;

import com.bookstore.management.bookstore_management.dto.AuthorDto;
import com.bookstore.management.bookstore_management.dto.DeleteResponse;

public interface AuthorService {


	AuthorDto createAuthor(AuthorDto authorDto);

	AuthorDto updateAuthorDetails(AuthorDto authorDto, Long id);
	
	AuthorDto updateAuthorDetailsPartially(Map<String, Object> fields, Long id);
	
	AuthorDto getAuthor(Long id);

	List<AuthorDto> getAllAuthor();

	DeleteResponse deleteAuthor(Long id);

	

}
