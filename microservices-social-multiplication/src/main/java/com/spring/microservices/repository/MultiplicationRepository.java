package com.spring.microservices.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.microservices.domain.Multiplication;

/**
* This interface allows us to save and retrieve Multiplications
*/
public interface MultiplicationRepository extends CrudRepository<Multiplication, Long>{

}
