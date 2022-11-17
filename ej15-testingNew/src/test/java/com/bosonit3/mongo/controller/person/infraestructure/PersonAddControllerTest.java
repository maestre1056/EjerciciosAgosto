package com.bosonit3.mongo.controller.person.infraestructure;

import com.bosonit3.mongo.person.application.PersonServiceImp;
import com.bosonit3.mongo.person.domain.Person;
import com.bosonit3.mongo.person.infraestructure.controller.PersonAddController;
import com.bosonit3.mongo.person.infraestructure.input.PersonInputDto;
import com.bosonit3.mongo.person.infraestructure.mapper.PersonMapper;
import com.bosonit3.mongo.person.infraestructure.output.PersonOutputDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.web.servlet.function.ServerResponse.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PersonAddController.class)
public class PersonAddControllerTest {
    @Autowired
    private MockMvc mvc;
    
    @Autowired
    ObjectMapper objectMapper;
    
    @MockBean
    private PersonServiceImp personServiceImp;
    
    @InjectMocks
    private PersonAddController underTest;
    
    private PersonInputDto personInputDto;
    private List<PersonOutputDto> personOutputList;
    private PersonOutputDto personOutputDto;
    private Date date = new Date();

    @BeforeEach
     void setUp() {
        
        Date date = new Date();
        personInputDto = new PersonInputDto((long) 1, "maestransa", "456", "Antonio",
                "Maestre", "antonio@gmail.com", "antonio@gmail.com",
                "Cordoba", false, date);
        
        Person person = PersonMapper.Instance.personInputDtoToPerson(personInputDto);
        personOutputDto = PersonMapper.Instance.personToPersonOutputDto(person);
        personOutputList = new ArrayList<>();
        this.personOutputList.add(personOutputDto);
    }
    
    @Test
    void shouldAddPerson()throws Exception{
        when(personServiceImp.addPerson(personInputDto)).thenReturn(personOutputDto);
        
        mvc.perform(post("/person").contentType("application/json")
                .content(objectMapper.writeValueAsString(personInputDto)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    


}
