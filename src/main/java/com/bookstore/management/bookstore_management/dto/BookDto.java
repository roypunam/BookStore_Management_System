package com.bookstore.management.bookstore_management.dto;

import com.bookstore.management.bookstore_management.entity.BookEntity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class BookDto {

	@NotEmpty(message = "The title is required.")
	@Size(min = 2, max = 100, message = "The length of title must be between 5 and 100 characters.")
	String title;
	@NotNull(message = "The isbn is required.")
	String isbn;

	public static BookEntity getBook(BookDto dto) {
		BookEntity book = new BookEntity();
		book.setTitle(dto.getTitle());
		book.setIsbn(dto.getIsbn());
		return book;
	}

}
