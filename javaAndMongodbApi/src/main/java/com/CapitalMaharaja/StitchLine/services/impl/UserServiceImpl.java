package com.CapitalMaharaja.StitchLine.services.impl;

import com.CapitalMaharaja.StitchLine.dto.UserDTO;
import com.CapitalMaharaja.StitchLine.entity.User;
import com.CapitalMaharaja.StitchLine.exception.ValidateException;
import com.CapitalMaharaja.StitchLine.repo.UserRepo;
import com.CapitalMaharaja.StitchLine.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepo userRepo;


    @Override
    public boolean saveCustomer(UserDTO dto) {
//        if (userRepo.existsById(dto.getUserName())) {
//            throw new ValidateException("Customer Already Exist");
//        }
        userRepo.save(mapper.map(dto, User.class));

        return true;
    }

    @Override
    public UserDTO searchCustomer(String id) {
        Optional<User> customer = userRepo.findById(id);
        if (customer.isPresent()) {
            return mapper.map(customer.get(), UserDTO.class);
        }
        return null;
    }





}
