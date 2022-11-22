package com.bosonit.ej15.security.role.application;

import com.bosonit.ej15.security.person.domain.Person;
import com.bosonit.ej15.security.person.infraestructure.repository.PersonRepository;
import com.bosonit.ej15.security.role.domain.Role;
import com.bosonit.ej15.security.role.infraestructure.dto.RoleDTO;
import com.bosonit.ej15.security.role.infraestructure.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
@Service
@Transactional
@Slf4j
public class RoleServiceImp implements RoleService{

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PersonRepository personRepository;

    @Override
    public Role addRole(RoleDTO roleDTO) {
        return roleRepository.save(new Role(roleDTO));
    }

    @Override
    public void addRoleToPerson(String username, String roleName) {
        Person person = personRepository.findByUsername(username);
        Role role = roleRepository.findByRoleName(roleName);
        Collection<Role> roles = person.getRoles();
        if (!roles.contains(role)) {
            person.getRoles().add(role);
            personRepository.save(person);
        }
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void deleteRole(Long idRole) {
        roleRepository.deleteById(idRole);
    }
}
