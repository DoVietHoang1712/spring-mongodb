package com.example.springmongodbsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
@Data
@AllArgsConstructor
public class User {
    @Id
    private String id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String gender;
    private Boolean isActive;
    private Boolean isEmailVerified;

    @Email
    private String email;

    @DBRef
    private Set<Role> roles = new HashSet<>();

    public User() {
        super();
    }

    public User(User user) {
        id = user.getId();
        username = user.getUsername();
        password = user.getPassword();
        email = user.getEmail();
        roles = user.getRoles();
        gender = user.getGender();
    }

    public void addRole(Role role) {
        roles.add(role);
        // role.getUserList().add(this);
    }

    public void addRoles(Set<Role> roles) {
        roles.forEach(this::addRole);
    }
}
