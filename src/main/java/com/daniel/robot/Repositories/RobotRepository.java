package com.daniel.robot.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.daniel.robot.Models.Robot;

public interface RobotRepository extends MongoRepository<Robot, String> {
}
