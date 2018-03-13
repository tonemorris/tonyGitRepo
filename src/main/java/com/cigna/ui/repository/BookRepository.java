/**
 * 
 */
package com.tivo.ui.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tivo.ui.domain.Book;

/**
 * @author anthonymorris
 *
 */
@Repository
public interface BookRepository extends MongoRepository<Book, String> {

	/**
	 * @param name
	 * @return
	 */
	List<Book> findByName(String name);

}
