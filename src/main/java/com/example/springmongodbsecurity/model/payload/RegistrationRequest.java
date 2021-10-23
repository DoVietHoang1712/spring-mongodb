package com.example.springmongodbsecurity.model.payload;

import com.example.springmongodbsecurity.model.Gender;
import com.example.springmongodbsecurity.model.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    private String username;
    private String email;
    private String password;
    // private RoleName role;
    private Gender gender;
}
