package com.spring.microservices.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.spring.microservices.domain.User;

/**
* This interface allows us to save and retrieve Users
*/
public interface UserRepository extends CrudRepository<User, Long>{
	Optional<User> findByAlias(String alias);
}
