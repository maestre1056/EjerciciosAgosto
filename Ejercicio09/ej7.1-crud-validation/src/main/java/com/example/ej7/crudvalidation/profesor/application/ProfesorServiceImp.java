package com.example.ej7.crudvalidation.profesor.application;

import com.example.ej7.crudvalidation.estudiante.domain.Student;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.mapper.StudentMapper;
import com.example.ej7.crudvalidation.estudiante.infraestructure.repository.StudentRepository;
import com.example.ej7.crudvalidation.exception.EntityNotFoundException;
import com.example.ej7.crudvalidation.exception.UnprocessableEntityException;
import com.example.ej7.crudvalidation.persona.domain.Persona;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.mapper.PersonaMapper;
import com.example.ej7.crudvalidation.persona.infraestructure.repository.PersonaRepository;
import com.example.ej7.crudvalidation.profesor.domain.Profesor;
import com.example.ej7.crudvalidation.profesor.infraestructure.controller.input.ProfesorInputDto;
import com.example.ej7.crudvalidation.profesor.infraestructure.controller.mapper.ProfesorMapper;
import com.example.ej7.crudvalidation.profesor.infraestructure.controller.output.ProfesorOutputDto;
import com.example.ej7.crudvalidation.profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImp implements ProfesorService{
    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addProfesor(ProfesorInputDto profesorInputDto) {
        if(profesorInputDto.getPersona()==null || profesorInputDto.getPersona().getIdPersona()==null)
            throw new UnprocessableEntityException("EL campo id_persona no puede ser nulo");
        if(!profesorInputDto.getBranch().equals("Front") && !profesorInputDto.getBranch().equals("Back") && !profesorInputDto.getBranch().equals("FullStack"))
            throw new UnprocessableEntityException("branch does not have a valid value");

        Optional<Persona> personOpt=personaRepository.findById(profesorInputDto.getPersona().getIdPersona());

        if(personOpt.isEmpty())
            throw new EntityNotFoundException("La persona con este id no existe");

        Optional<Student> studentOpt=studentRepository.findByPersona(personOpt.get());
        Optional<Profesor> profesorOpt=profesorRepository.findByPersona(personOpt.get());

        if(studentOpt.isPresent()||profesorOpt.isPresent())
            throw new UnprocessableEntityException("Ya hay una persona estudiante o profesor");


        Profesor profesorEntity= ProfesorMapper.Instance.profesorInputDtoToProfesor(profesorInputDto);
        profesorRepository.save(profesorEntity);

        return "Persona añadida correctamente";
        //  return ProfesorMapper.Instance.profesorToProfesorOutputDto(profesorEntity);
    }

    @Override
    public List<ProfesorOutputDto> getAll() {
        List <Profesor> profesorList=profesorRepository.findAll();
        List<ProfesorOutputDto> dtoList=new ArrayList<>();
        for(Profesor profesor:profesorList){
            dtoList.add(ProfesorMapper.Instance.profesorToProfesorOutputDto(profesor));
        }
        return dtoList;
    }

    @Override
    public ProfesorOutputDto getById(Long id) throws EntityNotFoundException {
        Optional<Profesor> profesorOptional=profesorRepository.findById(id);
        if(profesorOptional.isEmpty())
            throw new EntityNotFoundException("No existe profesor con este id");
        Profesor profesorEntity=profesorOptional.get();
        return ProfesorMapper.Instance.profesorToProfesorOutputDto(profesorEntity);
    }

    @Override
    public String deleteById(Long id) throws EntityNotFoundException {
        Optional<Profesor> profesorOptional=profesorRepository.findById(id);
        if (profesorOptional.isEmpty())
            throw new EntityNotFoundException("No existe profesor con este id");
        profesorRepository.delete(profesorOptional.get());

        return "Persona borrada";
    }

    @Override
    public ProfesorOutputDto updateProfesor(ProfesorInputDto profesorInputDto, Long idProfesor) throws EntityNotFoundException {
        Optional<Profesor> profesorOpt=profesorRepository.findById(idProfesor);
        if (profesorOpt.isEmpty())
            throw new EntityNotFoundException("El profesor con este id no existe");
        if(profesorInputDto.getPersona() == null || profesorInputDto.getPersona().getIdPersona()==null)
            throw new UnprocessableEntityException("id_person can not be null");
        if(!profesorInputDto.getBranch().equals("Front") && !profesorInputDto.getBranch().equals("Back") && !profesorInputDto.getBranch().equals("FullStack"))
            throw new UnprocessableEntityException("branch does not have a valid value");

        Profesor profesorSave= ProfesorMapper.Instance.profesorInputDtoToProfesor(profesorInputDto);
        profesorSave.setIdProfesor(idProfesor);
        profesorSave=profesorRepository.save(profesorSave);
        return ProfesorMapper.Instance.profesorToProfesorOutputDto(profesorSave);

    }

    @Override
    public Optional<Profesor> getProfesorOptionalByPersona(Persona persona) {
        return profesorRepository.findByPersona(persona);
    }

    @Override
    public Optional<Profesor> getProfesorOptional(Long idProfesor) {
        return profesorRepository.findById(idProfesor);
    }
}
