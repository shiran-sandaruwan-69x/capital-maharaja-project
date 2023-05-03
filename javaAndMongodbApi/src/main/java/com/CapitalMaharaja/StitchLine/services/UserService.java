package com.CapitalMaharaja.StitchLine.services;

import com.CapitalMaharaja.StitchLine.dto.UserDTO;

public interface UserService {
    boolean saveCustomer(UserDTO dto);
    UserDTO searchCustomer(String id);
}
