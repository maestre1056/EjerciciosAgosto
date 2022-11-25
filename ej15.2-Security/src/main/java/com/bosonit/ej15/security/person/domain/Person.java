package com.bosonit.ej15.security.person.domain;

import com.bosonit.ej15.security.person.infraestructure.dto.PersonDTO;
import com.bosonit.ej15.security.role.domain.Role;
import com.bosonit.ej15.security.role.infraestructure.dto.RoleDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Table;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "Persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_person", nullable = false)
    private Long idPerson;

    @Column(unique = true)
    private String username;
    private String password;
    private String name;
    private String surname;
    private Integer age;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public Person(PersonDTO personDTO) {
        setIdPerson(personDTO.getIdPerson());
        setUsername(personDTO.getUsername());
        setPassword(personDTO.getPassword());
        setName(personDTO.getName());
        setSurname(personDTO.getSurname());
        setAge(personDTO.getAge());
        setRoles(personDTO.getRoles());
    }

/*
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("1234"));
    }
*/
}
