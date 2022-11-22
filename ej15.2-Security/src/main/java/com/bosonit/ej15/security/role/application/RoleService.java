package com.bosonit.ej15.security.role.application;

import com.bosonit.ej15.security.role.domain.Role;
import com.bosonit.ej15.security.role.infraestructure.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    Role addRole(RoleDTO roleDTO);
    void addRoleToPerson(String username, String roleName);
    List<Role> getAllRoles();
    void deleteRole(Long idRole);
}
