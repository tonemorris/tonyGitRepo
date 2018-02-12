/**
 * 
 */
package com.cigna.mongooplogreader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cigna.mongooplogreader.domain.Account;



/**
 * @author anthonymorris
 *
 */
@Repository
public interface MongoOplogReaderRepository extends JpaRepository<Account, String> {

}
