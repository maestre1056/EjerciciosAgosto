package com.bosonit3.mongo.controller.person.infraestructure;

import com.bosonit3.mongo.person.application.PersonServiceImp;
import com.bosonit3.mongo.person.domain.Person;
import com.bosonit3.mongo.person.infraestructure.controller.PersonAddController;
import com.bosonit3.mongo.person.infraestructure.controller.PersonDeleteController;
import com.bosonit3.mongo.person.infraestructure.controller.PersonGetController;
import com.bosonit3.mongo.person.infraestructure.input.PersonInputDto;
import com.bosonit3.mongo.person.infraestructure.mapper.PersonMapper;
import com.bosonit3.mongo.person.infraestructure.output.PersonOutputDto;
import com.bosonit3.mongo.person.infraestructure.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import java.awt.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import org.hamcrest.Matchers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(PersonDeleteController.class)
public class PersonDeleteControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private PersonServiceImp personServiceImp;

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonGetController underTest;

     PersonInputDto personInputDto;
     List<PersonOutputDto> personOutputList;
     PersonOutputDto personOutputDto;
     Date date = new Date();
     Person person;


    @BeforeEach
    void setUp() {

        Date date = new Date();
        personInputDto = new PersonInputDto((long) 1, "maestransa", "456", "Antonio",
                "Maestre", "antonio@gmail.com", "antonio@gmail.com",
                "Cordoba", false, date);

        person = PersonMapper.Instance.personInputDtoToPerson(personInputDto);
        personOutputDto = PersonMapper.Instance.personToPersonOutputDto(person);
        personOutputList = new ArrayList<>();
        this.personOutputList.add(personOutputDto);
    }

    @Test
    void shouldDeletePerson()throws Exception{
        mvc.perform(delete("/person/{id}", "1")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }
}
