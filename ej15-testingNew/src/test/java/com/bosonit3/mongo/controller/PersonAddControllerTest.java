package com.bosonit3.mongo.controller;

import com.bosonit3.mongo.person.application.PersonServiceImp;
import com.bosonit3.mongo.person.domain.Person;
import com.bosonit3.mongo.person.infraestructure.controller.PersonAddController;
import com.bosonit3.mongo.person.infraestructure.input.PersonInputDto;
import com.bosonit3.mongo.person.infraestructure.mapper.PersonMapper;
import com.bosonit3.mongo.person.infraestructure.output.PersonOutputDto;
import com.bosonit3.mongo.person.infraestructure.repository.PersonRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

@ContextConfiguration(classes = PersonAddControllerTest.class)
@ExtendWith(MockitoExtension.class)
@WebMvcTest
public class PersonAddControllerTest {

    @Autowired
    public MockMvc mockMvc;
    @Mock
    public PersonRepository personRepository;
    @MockBean
    PersonServiceImp personServiceImp;
    public ObjectMapper objectMapper = new ObjectMapper();
    @InjectMocks
    PersonAddController personAddController;
    Person person = null;
    PersonInputDto personInputDto = null;
    PersonOutputDto personOutputDto= null;


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
    void addPerson() throws JsonProcessingException {
        personOutputDto= PersonMapper.Instance.personToPersonOutputDto(person);
        Mockito.when(personServiceImp.addPerson(ArgumentMatchers.any())).thenReturn(personOutputDto);
        String json = objectMapper.writeValueAsString(personInputDto);
        System.out.println(json);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/person")
                .contentType(MediaType.APPLICATION_JSON).content(json);
    }
}
