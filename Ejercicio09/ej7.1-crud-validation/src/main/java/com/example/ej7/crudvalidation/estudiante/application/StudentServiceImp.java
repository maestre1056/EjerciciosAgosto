package com.example.ej7.crudvalidation.estudiante.application;

import com.example.ej7.crudvalidation.estudiante.domain.Student;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.input.StudentInputDto;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.mapper.StudentMapper;
import com.example.ej7.crudvalidation.estudiante.infraestructure.controller.output.StudentOutputDto;
import com.example.ej7.crudvalidation.estudiante.infraestructure.repository.StudentRepository;
import com.example.ej7.crudvalidation.exception.EntityNotFoundException;
import com.example.ej7.crudvalidation.persona.domain.Persona;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.mapper.PersonaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    public StudentOutputDto addStudent(StudentInputDto studentInputDto) {
        Student studentEntity= StudentMapper.Instance.studentInputDtoToStudent(studentInputDto);
        studentEntity=studentRepository.save(studentEntity);

        return StudentMapper.Instance.studentToStudentOutputDto(studentEntity);
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
    public StudentOutputDto getById(Long id) throws EntityNotFoundException {
        Optional<Student> studentOpt=studentRepository.findById(id);
        if (studentOpt.isEmpty())
            throw new EntityNotFoundException("Estudiante con este id no existe");
        return StudentMapper.Instance.studentToStudentOutputDto(studentOpt.get());
    }


    @Override
    public String deleteStudent(Long id) throws EntityNotFoundException{
        Optional<Student> studentOpt=studentRepository.findById(id);
        if (studentOpt.isEmpty())
            throw new EntityNotFoundException("Estudiante con este id no existe");
        studentRepository.delete(studentOpt.get());

        return "El estudiante ha sido borrado";
    }


    @Override
    public StudentOutputDto updateStudent(StudentInputDto studentInputDto,Long id) {
        Optional<Student> studentOpt=studentRepository.findById(id);
        if(studentOpt.isEmpty())
            throw new EntityNotFoundException("El estudiante con este id no existe");
        Student studentSave=StudentMapper.Instance.studentInputDtoToStudent(studentInputDto);
        studentSave.setId_student(id);
        studentSave=studentRepository.save(studentSave);
        return StudentMapper.Instance.studentToStudentOutputDto(studentSave);
    }
}
