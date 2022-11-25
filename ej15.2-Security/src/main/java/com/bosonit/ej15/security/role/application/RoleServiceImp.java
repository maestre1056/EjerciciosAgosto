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
import java.util.Optional;

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
    public Person addRoleToPerson(String username, String roleName) {
       Optional<Person>  personOpt = personRepository.findByUsername(username);
       Person person=personOpt.get();
        Role role = roleRepository.findByRoleName(roleName);
        List<Role> roles = person.getRoles();
        if (!roles.contains(role)) {
            person.getRoles().add(role);
            personRepository.save(person);
        }
        return person;
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
