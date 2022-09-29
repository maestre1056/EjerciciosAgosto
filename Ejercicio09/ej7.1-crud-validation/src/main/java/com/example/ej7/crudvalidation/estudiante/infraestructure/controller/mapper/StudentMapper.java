package com.example.ej7.crudvalidation.estudiante.infraestructure.controller.mapper;

import com.example.ej7.crudvalidation.estudiante.domain.Student;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.input.StudentInputDto;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.output.StudentAllDetailsDto;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.output.StudentOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper Instance = Mappers.getMapper(StudentMapper.class);
    StudentOutputDto studentToStudentOutputDto(Student student);
    Student studentInputDtoToStudent(StudentInputDto studentInputDto);



    StudentAllDetailsDto studentToStudentAllDetailsDto(Student student);

}
