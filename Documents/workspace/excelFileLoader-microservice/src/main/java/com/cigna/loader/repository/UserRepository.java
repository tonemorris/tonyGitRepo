package com.cigna.loader.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cigna.loader.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
