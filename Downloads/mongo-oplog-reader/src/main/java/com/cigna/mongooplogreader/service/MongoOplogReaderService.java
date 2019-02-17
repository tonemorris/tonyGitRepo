/**
 * 
 */
package com.cigna.mongooplogreader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cigna.mongooplogreader.domain.Account;
import com.cigna.mongooplogreader.repository.MongoOplogReaderRepository;

/**
 * @author anthonymorris
 *
 */
@Service
public class MongoOplogReaderService {
	
	@Autowired
	private MongoOplogReaderRepository mongoOplogReaderRepository;

	/**
	 * @param order
	 */
	public void copy(Account account) {
		mongoOplogReaderRepository.save(account);	
	}

}
