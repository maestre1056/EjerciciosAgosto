package com.bosonit3.mongo.service;

import com.bosonit3.mongo.person.application.PersonService;
import com.bosonit3.mongo.person.application.PersonServiceImp;
import com.bosonit3.mongo.person.domain.Person;
import com.bosonit3.mongo.person.exception.EntityNotFoundException;
import com.bosonit3.mongo.person.infraestructure.input.PersonInputDto;
import com.bosonit3.mongo.person.infraestructure.mapper.PersonMapper;
import com.bosonit3.mongo.person.infraestructure.output.PersonOutputDto;
import com.bosonit3.mongo.person.infraestructure.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceImpTest {
    @Autowired
    private Mock mockMvc;
    @Mock
    public PersonRepository personRepository;
    @InjectMocks
    public PersonService underTest = new PersonServiceImp();
    Person person = null;
    PersonInputDto personInputDto = null;
    PersonOutputDto personOutputDto = null;

    @BeforeEach
    public void setUp(){
        long id = 1;
        Date date = new Date();
        personInputDto = new PersonInputDto(id,"maestransa","456","Antonio",
                "Maestre","antonio@gmail.com","antonio@gmail.com",
                "Cordoba",false,date);
       person = PersonMapper.Instance.personInputDtoToPerson(personInputDto);
    }

    @Test
    void viewId() throws Exception {
        // given
        personRepository.save(person);
        given(personRepository.findById(person.getId())).willReturn(Optional.of(person));
        //when
        underTest.findById(person.getId());
        //then
        verify(personRepository).findById(person.getId());
    }

    @Test
    void idThrowException() throws Exception {
        // given
        long id = 2;
        personRepository.save(person);
        // when
        assertThrows(EntityNotFoundException.class,()->{underTest.findById(id);});
        // then
        verify(personRepository).findById(any());
    }



    @Test
    void CanGetAllPeopleByUsername() throws Exception{
        // given
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        when(personRepository.findByUsername(person.getUsername())).thenReturn(personList);

        //when
        underTest.findPeopleByUsername(person.getUsername());

        //then
        verify(personRepository).findByUsername(person.getUsername());
        assertThat(person.getUsername()).isNotNull();
        assertThrows(EntityNotFoundException.class,()->{underTest.findPeopleByUsername(isNull());});

    }
    @Test
    void CanGetPeople(){
        // given
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        when(personRepository.findAll()).thenReturn(personList);

        //when
        List<PersonOutputDto> personOutputList = underTest.findPeople();

        //then
        verify(personRepository).findAll();
        assertThat(personOutputList).isNotNull();
        assertThat(personOutputList.size()).isEqualTo(1);
        assertThat(personOutputList).isExactlyInstanceOf(ArrayList.class);

    }
}
