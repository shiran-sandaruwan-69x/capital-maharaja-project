package com.example.demo.controller

import com.example.demo.dto.UserDTO
import com.example.demo.entity.User
import com.example.demo.exeception.HeroNotFoundException
import com.example.demo.repo.UserRepo
import com.sun.deploy.util.SessionState.save
import com.sun.javaws.LocalInstallHandler.save
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
class LoginController(val userRepo: UserRepo) {

    @GetMapping("/login")
    fun getUsers() = UserDTO(userRepo.findAll())

    @GetMapping(value = "/user/{id}")
    fun geUserById(@PathVariable("id") id : String) = userRepo.findById(id) ?: throw HeroNotFoundException("Hero with id: $id not found")


    @PostMapping(value = "/user")
    fun createHero(@RequestBody user: User, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<User> {
        val savedHero = userRepo.save(user)
//        val location = uriComponentsBuilder.path("/heroes/{id}").buildAndExpand(savedHero.id).toUri()
        return ResponseEntity.ok(savedHero);
    }


}
