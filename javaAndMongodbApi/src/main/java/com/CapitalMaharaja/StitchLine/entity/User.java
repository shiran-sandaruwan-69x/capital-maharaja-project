package com.CapitalMaharaja.StitchLine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "User")
public class User {
   @Id
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
