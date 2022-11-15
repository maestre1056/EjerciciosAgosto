package com.bosonit.ejercicio15.testing.person.application;

import com.bosonit.ejercicio15.testing.person.domain.Person;
import com.bosonit.ejercicio15.testing.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.ejercicio15.testing.person.infraestructure.controller.mapper.PersonMapper;
import com.bosonit.ejercicio15.testing.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.ejercicio15.testing.person.infraestructure.repository.PersonRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceImpTest {


    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private PersonServiceImp underTest;
private boolean init=false;
    @BeforeEach
    public void setUp() {

    }
    @Test
    void canAddPerson(){
        //given
        long id = 1;
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
       PersonOutputDto personLoad = underTest.addPerson(personInputDto);

       //then
        assertThat(personLoad).isNotNull();

    }



    @Test
    void canAddOtherPerson(){
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
        //when
        underTest.addPerson(personInputDto);

        //then
        Person person = PersonMapper.Instance.personInputDtoToPerson(personInputDto);
        ArgumentCaptor<Person> personArgumentCaptor =
                ArgumentCaptor.forClass(Person.class);

        verify(personRepository)
                .save(personArgumentCaptor.capture());

        Person capturedPerson = personArgumentCaptor.getValue();

        assertThat(PersonMapper.Instance.personToPersonOutputDto(capturedPerson) )
                .isEqualTo(PersonMapper.Instance.personToPersonOutputDto(person));

    }
    @Test
    void canAddsOtherPerson(){
        //given
        long id = 1;

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

        //when

        PersonOutputDto personOutputDto = underTest.addPerson(personInputDto);

        Person person = PersonMapper.Instance.personInputDtoToPerson(personInputDto);
        PersonOutputDto personOutputDto1 = PersonMapper.Instance.personToPersonOutputDto(person);
        personOutputDto.setId(id);
        personOutputDto1.setId(id);
        //then
        assertThat(personOutputDto).isEqualTo(personOutputDto1);
    }


    @Test
    void findById() {
    }

    @Test
    void CanGetAll() {
        //when

    }

    @Test
    void findPeopleByUsername() {
        underTest.findPeopleByUsername("pepe");
    }

    @Test
    void deletePerson() {
        Person person = new Person();
        person.setCity("madrid");

        Mockito.when(personRepository.findById((long) 1)).thenReturn(Optional.of(person));


            underTest.deletePerson((long) 1);
    }

    @Test
    void update() {
    }

    @Test
    void canFindAll() {
        //when
        underTest.findAll();
        //then
        verify(personRepository).findAll();
    }
}