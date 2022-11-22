package com.example.ej7.crudvalidation.role.infraestructure.dto;

import com.example.ej7.crudvalidation.role.domain.Role;
import lombok.Data;

@Data
public class RoleInputDto {
    private String roleName;

    public Role transformToRole(){
       Role role = new Role();
       role.setRoleName(this.roleName);
       return role;
    }

    public RoleInputDto(String roleName) {
        this.roleName = roleName;
    }
}
