package com.bosonit.ej15.security.role.infraestructure.dto;

import com.bosonit.ej15.security.role.domain.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleDTO {
    private Long idRole;
    private String roleName;

    public RoleDTO(Role role) {
        setIdRole(role.getIdRole());
        setRoleName(role.getRoleName());
    }

    public RoleDTO(Long idRole, String roleName) {
        setIdRole(idRole);
        setRoleName(roleName);
    }
}
