package com.example.ej7.crudvalidation.estudios.application;

import com.example.ej7.crudvalidation.estudiante.domain.Student;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.input.StudentInputDto;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.mapper.StudentMapper;
import com.example.ej7.crudvalidation.estudiante.infraestructure.repository.StudentRepository;
import com.example.ej7.crudvalidation.estudios.domain.AlumnosEstudios;
import com.example.ej7.crudvalidation.estudios.infraestructure.controller.input.EstudiosInputDto;
import com.example.ej7.crudvalidation.estudios.infraestructure.controller.mapper.EstudiosMapper;
import com.example.ej7.crudvalidation.estudios.infraestructure.controller.output.EstudiosOutputDto;
import com.example.ej7.crudvalidation.estudios.infraestructure.repository.EstudiosRepository;
import com.example.ej7.crudvalidation.exception.EntityNotFoundException;
import com.example.ej7.crudvalidation.exception.UnprocessableEntityException;
import com.example.ej7.crudvalidation.profesor.domain.Profesor;
import com.example.ej7.crudvalidation.profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstudiosServiceImp implements EstudiosService{
    @Autowired
    EstudiosRepository estudiosRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ProfesorRepository profesorRepository;


    @Override
    public EstudiosOutputDto addEstudios(EstudiosInputDto estudiosInputDto) {
        if(estudiosInputDto.getProfesor() == null)
            throw new UnprocessableEntityException("id_teacher can not be null");
        if(estudiosInputDto.getAsignatura().isBlank())
            throw new UnprocessableEntityException("subject can not be null or blank");
        if(estudiosInputDto.getInitialDate() == null)
            throw new UnprocessableEntityException("Initial date can not be null");

        Optional<Profesor> teacherOptional = profesorRepository.findById(estudiosInputDto.getProfesor().getIdProfesor());

        if(teacherOptional.isEmpty())
            throw new UnprocessableEntityException("The teacher does not exist");

        AlumnosEstudios estudiosEntity= EstudiosMapper.Instance.estudiosInputDtoToAlumnosEstudios(estudiosInputDto);
       estudiosEntity = estudiosRepository.save(estudiosEntity);

        return EstudiosMapper.Instance.alumnosEstudiosToEstudiosOutputDto(estudiosEntity);
    }



    @Override
    public EstudiosOutputDto updateEstudios(Long idEstudios, EstudiosInputDto estudiosInputDto) {
        AlumnosEstudios alumnosEstudios=estudiosRepository.findById(idEstudios).orElseThrow(()
                ->new EntityNotFoundException("La asignatura con este id no existe"));
        if(estudiosInputDto.getProfesor()==null)
            throw new UnprocessableEntityException("El campo profesor no puede ser nulo");
        if(estudiosInputDto.getAsignatura().isBlank())
            throw new UnprocessableEntityException("El campo asignatura no puede ser nulo");
        if(estudiosInputDto.getInitialDate()==null)
            throw new UnprocessableEntityException("El campo initial date no puede ser nulo");

       // Optional<Profesor> profesor=profesorRepository.findById(estudiosInputDto.getProfesor().getIdProfesor());
        AlumnosEstudios estudiosSave= EstudiosMapper.Instance.estudiosInputDtoToAlumnosEstudios(estudiosInputDto);
        estudiosSave.setIdEstudios(idEstudios);
        estudiosSave=estudiosRepository.save(estudiosSave);

        return EstudiosMapper.Instance.alumnosEstudiosToEstudiosOutputDto(estudiosSave);

    }

    @Override
    public EstudiosOutputDto findEstudiosById(Long idEstudios) {
        Optional<AlumnosEstudios> estudiosOpt=estudiosRepository.findById(idEstudios);
        if (estudiosOpt.isEmpty())
            throw new EntityNotFoundException("La asignatura con este id no existe");
        return EstudiosMapper.Instance.alumnosEstudiosToEstudiosOutputDto(estudiosOpt.get());
    }

    @Override
    public String deleteEstudios(Long idEstudios) {
        Optional<AlumnosEstudios> estudiosOpt=estudiosRepository.findById(idEstudios);
        if (estudiosOpt.isEmpty())
            throw new EntityNotFoundException("La asignatura con este id no existe");
        estudiosRepository.delete(estudiosOpt.get());

        return "Persona borrada correctamente";
    }
}
