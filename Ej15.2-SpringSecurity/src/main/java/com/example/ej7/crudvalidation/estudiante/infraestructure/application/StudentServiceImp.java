package com.example.ej7.crudvalidation.estudiante.infraestructure.application;

import com.example.ej7.crudvalidation.estudiante.domain.Student;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.input.StudentInputDto;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.mapper.StudentMapper;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.output.StudentOutputDto;
import com.example.ej7.crudvalidation.estudiante.infraestructure.repository.StudentRepository;
import com.example.ej7.crudvalidation.estudios.infraestructure.repository.EstudiosRepository;
import com.example.ej7.crudvalidation.exception.EntityNotFoundException;
import com.example.ej7.crudvalidation.exception.UnprocessableEntityException;
import com.example.ej7.crudvalidation.persona.application.PersonaService;
import com.example.ej7.crudvalidation.persona.domain.Persona;
import com.example.ej7.crudvalidation.profesor.application.ProfesorService;
import com.example.ej7.crudvalidation.profesor.domain.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonaService personaService;

    @Autowired
    ProfesorService profesorService;

    @Autowired
    EstudiosRepository estudiosRepository;




    public String addStudent(StudentInputDto studentInputDto) {

        if(studentInputDto.getPersona()==null)
            throw new UnprocessableEntityException("EL id de persona no puede estar nulo");
        if(studentInputDto.getNumHoursWeek() == null)
            throw new UnprocessableEntityException("num_hours_week can not be null");
        if(!studentInputDto.getRama().equals("Front")&& !studentInputDto.getRama().equals("Back")&& !studentInputDto.getRama().equals("FullStack"))
            throw new UnprocessableEntityException("Esta rama no es válida");

        Optional<Persona> personaOpt=personaService.getPersonaOptional(studentInputDto.getPersona().getIdPersona());
        if (personaOpt.isEmpty())
            throw new EntityNotFoundException("La persona no existe");

        Optional<Profesor> profesorOpt=profesorService.getProfesorOptionalByPersona(personaOpt.get());
        Optional<Student> studentOpt=studentRepository.findByPersona(personaOpt.get());

        if(profesorOpt.isPresent()||studentOpt.isPresent())
            throw new UnprocessableEntityException("La persona ya es estudiante o profesor");

        Student studentEntity= StudentMapper.Instance.studentInputDtoToStudent(studentInputDto);
        studentEntity=studentRepository.save(studentEntity);

        return "Persona añadida correctamente";
    }

    @Override
    public List<StudentOutputDto> getAll() {
        List<Student> studentList=studentRepository.findAll();
        List<StudentOutputDto> studentDtoList=new ArrayList<>();
        for (Student student:studentList){
            studentDtoList.add(StudentMapper.Instance.studentToStudentOutputDto(student));
        }
        return studentDtoList;
    }


    @Override
    public StudentOutputDto getById(Long idStudent) throws EntityNotFoundException {
        Optional<Student> studentOpt=studentRepository.findById(idStudent);
        if (studentOpt.isEmpty())
            throw new EntityNotFoundException("Estudiante con este id no existe");
        return StudentMapper.Instance.studentToStudentOutputDto(studentOpt.get());
    }


    @Override
    public String deleteStudent(Long idStudent) throws EntityNotFoundException{
        Optional<Student> studentOpt=studentRepository.findById(idStudent);
        if (studentOpt.isEmpty())
            throw new EntityNotFoundException("Estudiante con este id no existe");
        studentRepository.delete(studentOpt.get());

        return "El estudiante ha sido borrado";
    }


    @Override
    public StudentOutputDto updateStudent(StudentInputDto studentInputDto,Long idStudent) {
        Optional<Student> studentOpt=studentRepository.findById(idStudent);
        if(studentOpt.isEmpty())
            throw new EntityNotFoundException("El estudiante con este id no existe");
        if(studentInputDto.getPersona()==null)
            throw new UnprocessableEntityException("El id de persona no puede ser nulo");
        if(studentInputDto.getNumHoursWeek()==null)
            throw new UnprocessableEntityException("Horas semanales no puede ser nulo");
        if(!studentInputDto.getRama().equals("Back")&& !studentInputDto.getRama().equals("Front")&& !studentInputDto.getRama().equals("FullStack"))
            throw new UnprocessableEntityException("Rama no válida");

        Optional<Persona> personaOpt=personaService.getPersonaOptional(studentInputDto.getPersona().getIdPersona());

        if(personaOpt.isEmpty())
            throw new EntityNotFoundException("La persona con este id no exista");

        Optional<Profesor> profesorOpt=profesorService.getProfesorOptionalByPersona(personaOpt.get());
        Optional<Student> studentOptional=studentRepository.findByPersona(personaOpt.get());

        if(!Objects.equals(studentInputDto.getPersona().getIdPersona(), studentOpt.get().getPersona().getIdPersona()))
            if(profesorOpt.isPresent()||studentOptional.isPresent())
                throw new UnprocessableEntityException("LA persona ya es estudiante o profesor");

       // profesorOpt=profesorService.getProfesorOptional(studentInputDto.getProfesor().getId_profesor());

        Student studentSave=StudentMapper.Instance.studentInputDtoToStudent(studentInputDto);
        studentSave.setIdStudent(idStudent);
        studentSave=studentRepository.save(studentSave);

        return StudentMapper.Instance.studentToStudentOutputDto(studentSave);
    }

    @Override
    public String addSubjectToStudent(Long idStudent, List<Long> idEstudios) {
        return null;
    }

    @Override
    public String deleteSubjectFromStudent(Long idStudent, List<Long> idEstudios) {
        return null;
    }
}
