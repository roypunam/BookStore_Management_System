package com.bookstore.management.bookstore_management.entity;

import com.bookstore.management.bookstore_management.dto.BookDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * <b>Book Entity</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "book")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	Long bookId;
	
	@Column(name = "book_title")
	String title;
	@Column(name = "isbn")
	String isbn;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

	public static BookDto getBookDto(BookEntity book) {
		BookDto dto = new BookDto();
		dto.setTitle(book.getTitle());
		dto.setIsbn(book.getIsbn());
		return dto;

	}

}
