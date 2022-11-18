package com.example.ej7.crudvalidation.estudios.infraestructure.controller.mapper;

import com.example.ej7.crudvalidation.estudiante.domain.Student;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.input.StudentInputDto;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.mapper.StudentMapper;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.output.StudentOutputDto;
import com.example.ej7.crudvalidation.estudios.domain.AlumnosEstudios;
import com.example.ej7.crudvalidation.estudios.infraestructure.controller.input.EstudiosInputDto;
import com.example.ej7.crudvalidation.estudios.infraestructure.controller.input.EstudiosInputIdDto;
import com.example.ej7.crudvalidation.estudios.infraestructure.controller.output.EstudiosOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstudiosMapper {
    EstudiosMapper Instance = Mappers.getMapper(EstudiosMapper.class);
    EstudiosOutputDto alumnosEstudiosToEstudiosOutputDto(AlumnosEstudios alumnosEstudios);
    AlumnosEstudios estudiosInputDtoToAlumnosEstudios(EstudiosInputDto estudiosInputDto);

    AlumnosEstudios estudiosInputIdDtoToAlumnosEstudios(EstudiosInputIdDto estudiosInputIdDto);
}
