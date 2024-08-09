package com.bookstore.management.bookstore_management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.management.bookstore_management.dto.AuthorDto;
import com.bookstore.management.bookstore_management.dto.DeleteResponse;
import com.bookstore.management.bookstore_management.entity.AuthorEntity;
import com.bookstore.management.bookstore_management.exception.AuthorNotFoundException;
import com.bookstore.management.bookstore_management.repository.AuthorRepository;
import com.bookstore.management.bookstore_management.service.AuthorService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepo;
	
	

	@Override
	public AuthorDto createAuthor(AuthorDto authorDto) {
		log.info("createAuthor service impl called.");

		// DTO to AuthorEntity conversion
		AuthorEntity author = AuthorDto.getAuthor(authorDto);
		AuthorEntity savedAuthor = authorRepo.save(author);
		return AuthorEntity.getAuthorDto(savedAuthor);

	}

	@Override
	public AuthorDto updateAuthorDetails(AuthorDto authorDto, Long id) {
		log.info("updateAuthorDetails service impl called.");

		// Database called

		AuthorEntity author = authorRepo.findById(id)
				.orElseThrow(() -> new AuthorNotFoundException("AuthorEntity", "authorId", id));
		author.setAuthorName(authorDto.getAuthorName());
		author.setAuthorEmail(authorDto.getAuthorEmail());
		// Update details saved
		AuthorEntity updatedAuthorDetails = authorRepo.save(author);
		AuthorDto response = AuthorEntity.getAuthorDto(updatedAuthorDetails);
		return response;
	}

	@Override
	public AuthorDto updateAuthorDetailsPartially(Map<String, Object> fields, Long id) {
		log.info("updateAuthorDetailsPartially service impl called.");
		//Database called
		Optional<AuthorEntity> authorOptional = authorRepo.findById(id);

		if (authorOptional.isPresent()) {
			AuthorEntity author = authorOptional.get();
			fields.forEach((key, value) -> {
				switch (key) {
				case "authorName":
					author.setAuthorName((String) value);
					break;
				case "authorEmail":
					author.setAuthorEmail((String) value);
					break;

				}
			});
			AuthorEntity getAuthor = authorRepo.save(author);
			return AuthorEntity.getAuthorDto(getAuthor);
		} else {
			throw new RuntimeException("Author not found with id " + id);
		}
	}

	@Override
	public AuthorDto getAuthor(Long id) {
		log.info("getAuthor service impl called.");

		// Database called
		AuthorEntity author = authorRepo.findById(id)
				.orElseThrow(() -> new AuthorNotFoundException("AuthorEntity", "authorId", id));

		// AuthorEntity to DTO conversion
		AuthorDto response = AuthorEntity.getAuthorDto(author);
		return response;
	}

	@Override
	public List<AuthorDto> getAllAuthor() {
		log.info("getAllAuthor service impl called.");

		// Database called
		List<AuthorEntity> authorList = authorRepo.findAll();

		// AuthorEntity to DTO conversion
		List<AuthorDto> response = new ArrayList<>();
		for (AuthorEntity getauthor : authorList) {
			AuthorDto dto = AuthorEntity.getAuthorDto(getauthor);
			response.add(dto);
		}
		return response;

	}

	@Override
	public DeleteResponse deleteAuthor(Long id) {
		log.info("deleteAuthor service impl called.");

		// Database called to find author
		AuthorEntity author = authorRepo.findById(id)
				.orElseThrow(() -> new AuthorNotFoundException("AuthorEntity", "authorId", id));

		// Database called to delete author
		authorRepo.delete(author);
		return new DeleteResponse("Record of the author deleted successfully", true);
	}

}
