package com.example.ej7.crudvalidation.role.infraestructure.dto;

import com.example.ej7.crudvalidation.role.domain.Role;
import lombok.Data;

@Data
public class RoleOutputDto {
    private Long id_Role;
    private String roleName;

    public RoleOutputDto(Role role){
        this.id_Role=role.getId_Role();
        this.roleName = role.getRoleName();
    }
}
