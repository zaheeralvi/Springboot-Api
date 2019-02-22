package com.microservices.dev.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservices.dev.modal.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
