package com.example.ej7.crudvalidation.estudiante.application;

import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.input.StudentInputDto;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.output.StudentOutputDto;
import com.example.ej7.crudvalidation.exception.EntityNotFoundException;
import com.example.ej7.crudvalidation.exception.UnprocessableEntityException;

import java.util.List;

public interface StudentService {
    StudentOutputDto addStudent(StudentInputDto studentInputDto);

    List<StudentOutputDto> getAll();

    StudentOutputDto getById(Long id) throws EntityNotFoundException;

    String deleteStudent(Long id) throws EntityNotFoundException;

    StudentOutputDto updateStudent(StudentInputDto studentInputDto,Long id)throws EntityNotFoundException, UnprocessableEntityException;
}
