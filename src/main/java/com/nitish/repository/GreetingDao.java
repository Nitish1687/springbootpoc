package com.nitish.repository;

import com.nitish.domain.Greeting;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GreetingDao extends MongoRepository<Greeting,String> {

}
