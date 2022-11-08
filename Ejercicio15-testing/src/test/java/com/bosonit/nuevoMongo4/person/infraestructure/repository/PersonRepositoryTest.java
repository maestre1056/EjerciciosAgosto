package com.bosonit.nuevoMongo4.person.infraestructure.repository;

import com.bosonit.nuevoMongo4.person.domain.Person;
import com.bosonit.nuevoMongo4.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.nuevoMongo4.person.infraestructure.controller.mapper.PersonMapper;
import lombok.Data;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository underTest;

    @Test
    void itShouldFindByUsername() {
        //given
        Date date = new Date();
        PersonInputDto personInputDto = new PersonInputDto(
                "maestransa",
                "15489",
                "Antonio",
                "Maestre",
                "antonio.maestre@gmail",
                "antonio.maestre@gmail",
                "Cordoba",
                true,
                date
        );
        Person person = PersonMapper.Instance.personInputDtoToPerson(personInputDto);
        underTest.save(person);
        //when
        List<Person> expected = underTest.findByUsername(person.getUsername());
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        //then
        assertThat(expected).isEqualTo(personList);
    }



    @Test
    void itShouldFindAll() {
    }
}