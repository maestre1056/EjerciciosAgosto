package com.example.ej7.crudvalidation.role.infraestructure.dto;

import com.example.ej7.crudvalidation.role.domain.Role;
import lombok.Data;

@Data
public class RoleInputDto {
    private String name;

    public Role transformToRole(){
       Role role = new Role();
       role.setName(this.name);
       return role;
    }
}
