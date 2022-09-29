package com.example.ej7.crudvalidation.estudiante.infraestructure.application;

import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.input.StudentInputDto;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.output.StudentOutputDto;
import com.example.ej7.crudvalidation.exception.EntityNotFoundException;
import com.example.ej7.crudvalidation.exception.UnprocessableEntityException;

import java.util.List;

public interface StudentService {
    String addStudent(StudentInputDto studentInputDto);

    List<StudentOutputDto> getAll();

    StudentOutputDto getById(Long idStudent) throws EntityNotFoundException;

    String deleteStudent(Long idStudent) throws EntityNotFoundException;

    StudentOutputDto updateStudent(StudentInputDto studentInputDto,Long id)throws EntityNotFoundException, UnprocessableEntityException;

    String addSubjectToStudent(Long idStudent,List<Long> idEstudios);

    String deleteSubjectFromStudent(Long idStudent, List<Long> idEstudios);
}
