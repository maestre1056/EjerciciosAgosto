package com.bosonit3.mongo.repository;

import com.bosonit3.mongo.person.domain.Person;
import com.bosonit3.mongo.person.infraestructure.input.PersonInputDto;
import com.bosonit3.mongo.person.infraestructure.mapper.PersonMapper;
import com.bosonit3.mongo.person.infraestructure.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class PersonaRepositoryTest {
    @Autowired
    PersonRepository personRepository;
    Person person;
    PersonInputDto personInputDto;


    @BeforeEach
    public void beforeNamePerson(){
        long id = 1;
        Date date = new Date();
        personInputDto = new PersonInputDto(id,"maestransa","456","Antonio",
                "Maestre","antonio@gmail.com","antonio@gmail.com",
                "Cordoba",false,date);

    }
    @Test
    void itShouldCheckIfPersonByUsername(){
        //given
        //when
        person = personRepository.save(PersonMapper.Instance.personInputDtoToPerson(personInputDto));

        List<Person> personList = new ArrayList<>();
        personList.add(person);

        List<Person> personListByName =personRepository.findByUsername(person.getUsername());

        //then
        assertThat(personList).isEqualTo(personListByName);
    }
}
