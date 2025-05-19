package com.daniel.robot.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.daniel.robot.Models.Mision;

public interface MisionRepository extends MongoRepository<Mision, String> {
}
