package com.example.ej7.crudvalidation.role.application;

import com.example.ej7.crudvalidation.persona.domain.Persona;
import com.example.ej7.crudvalidation.persona.infraestructure.repository.PersonaRepository;
import com.example.ej7.crudvalidation.role.domain.Role;
import com.example.ej7.crudvalidation.role.infraestructure.dto.RoleInputDto;
import com.example.ej7.crudvalidation.role.infraestructure.dto.RoleOutputDto;
import com.example.ej7.crudvalidation.role.infraestructure.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Slf4j
@Transactional
public class RoleServiceImp implements RoleService{
    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    RoleRepository roleRepository;


    @Override
    public RoleOutputDto addRole(RoleInputDto roleInputDto) {
        Role role = roleInputDto.transformToRole();
        return new RoleOutputDto(roleRepository.save(role)) ;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Persona persona = personaRepository.findByUsername(username);
        Role role = roleRepository.findByRoleName(roleName);
        Collection<Role> roles = persona.getRoles();
        if(!roles.contains(role)){
            persona.getRoles().add(role);
            personaRepository.save(persona);
        }


    }
}
