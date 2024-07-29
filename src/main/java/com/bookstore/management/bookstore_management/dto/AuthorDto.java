package com.bookstore.management.bookstore_management.dto;

import com.bookstore.management.bookstore_management.entity.AuthorEntity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorDto {

	Long id;
	@NotEmpty(message = "The author name is required.")
	@Size(min = 2, max = 100, message = "The length of author name must be between 2 and 100 characters.")
	String authorName;
	@NotEmpty(message = "The email is required.")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Please give a valid email id.")
	String authorEmail;

	public static AuthorEntity getAuthor(AuthorDto dto) {
		AuthorEntity author = new AuthorEntity();
		author.setAuthorId(dto.getId());
		author.setAuthorName(dto.getAuthorName());
		author.setAuthorEmail(dto.getAuthorEmail());

		return author;
	}

}
