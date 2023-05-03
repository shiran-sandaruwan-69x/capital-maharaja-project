package com.example.demo.repo

import com.example.demo.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepo  : MongoRepository<User,String>
