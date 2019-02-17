package com.cigna.loader.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cigna.loader.domain.WorkProc;

@Repository
public interface WorkProcRepository extends CrudRepository<WorkProc, Long> {

}
