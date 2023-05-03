package com.CapitalMaharaja.StitchLine.repo;

import com.CapitalMaharaja.StitchLine.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String> {
}
