package com.jgmonteiro.course.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jgmonteiro.course.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
