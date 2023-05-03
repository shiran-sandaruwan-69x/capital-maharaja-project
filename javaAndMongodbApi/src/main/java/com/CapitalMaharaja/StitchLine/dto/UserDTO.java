package com.CapitalMaharaja.StitchLine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserDTO {
    private String userName;
    private String name;
    private String address;
    private String email;
    private String mobile;
    private String password;
    private String type;
    private String nic;
    private String emNumber;
}
