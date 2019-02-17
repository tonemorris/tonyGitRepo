/**
 * 
 */
package com.cigna.logreader.reader;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface BatchExecutionRepository extends MongoRepository<Batch, Long> {
	public Batch findTopByOrderByJobIdDesc();

}
