package com.bookstore.management.bookstore_management.service;

import java.util.List;
import java.util.Map;

import com.bookstore.management.bookstore_management.dto.AuthorDto;
import com.bookstore.management.bookstore_management.dto.DeleteResponse;

public interface AuthorService {


	AuthorDto createAuthor(AuthorDto authorDto);

	AuthorDto updateAuthorDetails(AuthorDto authorDto, Long id);

	List<AuthorDto> getAllAuthor();

	AuthorDto getAuthor(Long id);

	DeleteResponse deleteAuthor(Long id);

	AuthorDto updateAuthorDetailsPartially(Map<String, Object> updates, Long id);

}
