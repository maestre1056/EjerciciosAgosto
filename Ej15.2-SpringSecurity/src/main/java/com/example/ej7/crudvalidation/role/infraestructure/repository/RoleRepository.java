package com.example.ej7.crudvalidation.role.infraestructure.repository;

import com.example.ej7.crudvalidation.role.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
