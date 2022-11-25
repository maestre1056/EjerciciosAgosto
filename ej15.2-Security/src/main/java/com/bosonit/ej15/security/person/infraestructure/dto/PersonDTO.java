package com.bosonit.ej15.security.person.infraestructure.dto;

import com.bosonit.ej15.security.person.domain.Person;
import com.bosonit.ej15.security.role.domain.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
public class PersonDTO {

    private Long idPerson;
    private String username;
    private String password;
    private String name;
    private String surname;
    private Integer age;
    private List<Role> roles = new ArrayList<>();

    public PersonDTO(Person person) {
        setIdPerson(person.getIdPerson());
        setUsername(person.getUsername());
        setPassword(person.getPassword());
        setName(person.getName());
        setSurname(person.getSurname());
        setAge(person.getAge());
        setRoles(person.getRoles());
    }

    public PersonDTO(Long idPerson, String username, String password, String name, String surname, Integer age, List<Role> roles) {
        setIdPerson(idPerson);
        setUsername(username);
        setPassword(password);
        setName(name);
        setSurname(surname);
        setAge(age);
        setRoles(roles);
    }
}
