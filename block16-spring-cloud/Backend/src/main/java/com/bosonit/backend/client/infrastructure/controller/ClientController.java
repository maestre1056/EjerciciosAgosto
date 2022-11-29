package com.bosonit.backend.client.infrastructure.controller;

import com.bosonit.backend.client.application.ClientService;
import com.bosonit.backend.client.infrastructure.dto.ClientInputDto;
import com.bosonit.backend.client.infrastructure.dto.ClientOutputDto;
import com.bosonit.backend.exception.ErrorMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientOutputDto> addClient(@Valid @RequestBody ClientInputDto clientInputDto,
                                                     BindingResult result){
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,this.formatMessage(result));
        }
        ClientOutputDto clientOutputDto = clientService.addClient(clientInputDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientOutputDto);

    }

    @GetMapping
    public List<ClientOutputDto> getAll(){
        return  clientService.getAll();
    }

    @GetMapping("/{id}")
    public ClientOutputDto getById(@PathVariable Long id){
        return clientService.getById(id);
    }

    @PutMapping("/{id}")
    public ClientOutputDto updateClient(@PathVariable Long id, @RequestBody ClientInputDto clientInputDto){
        return clientService.updateCliente(id, clientInputDto);
    }

    @DeleteMapping("{id}")
    public String deleteClient(@PathVariable Long id){
        return clientService.deleteClient(id);
    }



    private String formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();

        ObjectMapper mapper = new ObjectMapper();
        String jsonString= "";
        try{
            jsonString = mapper.writeValueAsString(errorMessage);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return jsonString;
    }


}
