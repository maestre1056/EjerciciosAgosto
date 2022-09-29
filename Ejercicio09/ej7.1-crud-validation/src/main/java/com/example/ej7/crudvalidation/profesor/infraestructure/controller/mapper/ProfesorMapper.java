package com.example.ej7.crudvalidation.profesor.infraestructure.controller.mapper;

import com.example.ej7.crudvalidation.estudiante.domain.Student;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.input.StudentInputDto;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.mapper.StudentMapper;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.output.StudentOutputDto;
import com.example.ej7.crudvalidation.profesor.domain.Profesor;
import com.example.ej7.crudvalidation.profesor.infraestructure.controller.input.ProfesorInputDto;
import com.example.ej7.crudvalidation.profesor.infraestructure.controller.output.ProfesorOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfesorMapper {
    ProfesorMapper Instance = Mappers.getMapper(ProfesorMapper.class);
    ProfesorOutputDto profesorToProfesorOutputDto(Profesor profesor);
    Profesor profesorInputDtoToProfesor(ProfesorInputDto profesorInputDto);
}
