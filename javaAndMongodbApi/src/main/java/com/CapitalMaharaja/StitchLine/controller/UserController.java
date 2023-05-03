package com.CapitalMaharaja.StitchLine.controller;

import com.CapitalMaharaja.StitchLine.dto.UserDTO;
import com.CapitalMaharaja.StitchLine.services.UserService;
import com.CapitalMaharaja.StitchLine.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;



    @PostMapping("/addUser")
    public ResponseEntity addUsers(@RequestBody UserDTO userDTO){
    userService.saveCustomer(userDTO);
        StandardResponse response = new StandardResponse(200, "Success", userDTO);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }



    @GetMapping(path = "/{userName}/{password}")
    public ResponseEntity login(@PathVariable("userName") String val1, @PathVariable("password") String val2) {
//        String val1 = "sachini";
        // String val2="12342";

        UserDTO userDTO = userService.searchCustomer(val1);

        System.out.println(userDTO.getType());
        String type = userDTO.getType();

        if (userDTO != null) {


                StandardResponse response = new StandardResponse(200, type, userDTO);
                return new ResponseEntity(response, HttpStatus.CREATED);



        } else {
            StandardResponse response = new StandardResponse(500, "can't find this user...", null);
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }





}
