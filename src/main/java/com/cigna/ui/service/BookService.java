/**
 * 
 */
package com.tivo.ui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tivo.ui.domain.Book;
import com.tivo.ui.repository.BookRepository;

/**
 * @author anthonymorris
 *
 */
@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	/**
	 * @param name
	 * @return List<Book>
	 */
	public List<Book> findByName(String name) {
		return bookRepository.findByName(name);
	}
}
