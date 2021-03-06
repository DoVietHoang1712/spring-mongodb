package com.example.springmongodbsecurity.repository;

import com.example.springmongodbsecurity.model.Role;
import com.example.springmongodbsecurity.model.RoleName;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByRoleName(RoleName roleName);
}
