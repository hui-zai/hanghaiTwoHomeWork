package com.joey.dao;


import com.joey.pojo.User;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends MongoRepository<User, ObjectId> {

        List<User> findByUsername(String username);



}
