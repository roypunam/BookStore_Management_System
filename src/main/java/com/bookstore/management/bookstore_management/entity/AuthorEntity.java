package com.bookstore.management.bookstore_management.entity;

import java.util.List;

import com.bookstore.management.bookstore_management.dto.AuthorDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
/**
 * <b>Author Entity</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="author")
public class AuthorEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="author_id")
	Long authorId;
	
	@Column(name="author_name")
	String authorName;
	@Column(name="email_address")
	String authorEmail;
	
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<BookEntity> bookList;
	
	public static AuthorDto getAuthorDto(AuthorEntity author) {
		AuthorDto dto = new AuthorDto();
		dto.setAuthorName(author.getAuthorName());
		dto.setAuthorEmail(author.getAuthorEmail());
		return dto;

	}
	

}
