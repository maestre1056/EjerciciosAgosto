package com.example.ej7.crudvalidation.role.infraestructure.controller;

import com.example.ej7.crudvalidation.role.application.RoleService;
import com.example.ej7.crudvalidation.role.infraestructure.dto.RoleInputDto;
import com.example.ej7.crudvalidation.role.infraestructure.dto.RoleOutputDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class RoleAddController {
    @Autowired
    RoleService roleService;

    @PostMapping("/role")
    public ResponseEntity<RoleOutputDto>  addRole(@RequestBody RoleInputDto roleInputDto){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/role").toUriString());
        return ResponseEntity.created(uri).body(roleService.addRole(roleInputDto)) ;
    }

    @PostMapping("/roletouser")
    public ResponseEntity<? > roleToUser(@RequestBody RoleToUserForm form){
        roleService.addRoleToUser(form.getUsername(), form.getRoleName());

        return ResponseEntity.ok().build();
    }


    @Data
    class RoleToUserForm{
        private String username;
        private String roleName;
    }
}
