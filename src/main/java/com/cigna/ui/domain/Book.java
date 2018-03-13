
package com.tivo.ui.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author anthonymorris
 *
 */
@Document(collection = "books")
public class Book {
	
	@Id
    private Long id;
    private String name;
    private String author;

	/**
	 * @param name
	 * @param author
	 */
	public Book(String name, String author) {
		this.name = name;
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	

}
