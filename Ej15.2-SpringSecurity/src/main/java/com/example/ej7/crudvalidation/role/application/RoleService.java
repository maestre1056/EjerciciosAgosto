package com.example.ej7.crudvalidation.role.application;

import com.example.ej7.crudvalidation.role.domain.Role;
import com.example.ej7.crudvalidation.role.infraestructure.dto.RoleInputDto;
import com.example.ej7.crudvalidation.role.infraestructure.dto.RoleOutputDto;

public interface RoleService {
    RoleOutputDto addRole(RoleInputDto roleInputDto);
    void addRoleToUser(String username, String roleName);
}
