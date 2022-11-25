package com.bosonit.ej15.security.role.infraestructure.controller;

import com.bosonit.ej15.security.person.domain.Person;
import com.bosonit.ej15.security.role.application.RoleService;
import com.bosonit.ej15.security.role.domain.Role;
import com.bosonit.ej15.security.role.infraestructure.dto.RoleDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public Role addRole(@RequestBody RoleDTO roleDTO) {
        return roleService.addRole(roleDTO);
    }

    @PostMapping(value = "/addroletouser")
    public Person addRoleToUser(@RequestParam String username, @RequestParam String roleName) {
      return   roleService.addRoleToPerson(username, roleName);
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable("id") Long idRole) {
        try {
            roleService.deleteRole(idRole);
            return "The role with idRole " + idRole + " has been successfully eliminated.";
        } catch (Exception ex) {
            return "Error: " + ex.getMessage();
        }
    }


}
