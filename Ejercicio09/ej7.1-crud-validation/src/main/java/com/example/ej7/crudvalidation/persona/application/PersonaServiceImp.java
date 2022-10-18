package com.example.ej7.crudvalidation.persona.application;

import com.example.ej7.crudvalidation.exception.EntityNotFoundException;
import com.example.ej7.crudvalidation.exception.UnprocessableEntityException;
import com.example.ej7.crudvalidation.persona.domain.Persona;
import com.example.ej7.crudvalidation.persona.domain.PersonaPage;
import com.example.ej7.crudvalidation.persona.domain.PersonaSearchCriteria;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.input.PersonaInputDto;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.mapper.PersonaMapper;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonaOutputDto;
import com.example.ej7.crudvalidation.persona.infraestructure.controller.output.PersonaOutputDtoNew;
import com.example.ej7.crudvalidation.persona.infraestructure.repository.PersonaCriteriaRepository;
import com.example.ej7.crudvalidation.persona.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

//import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImp implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    PersonaCriteriaRepository personaCriteriaRepository;

    @Override
    public PersonaOutputDto addPersona(PersonaInputDto personaDto) throws UnprocessableEntityException {
        personaDto.setCreatedDate(new Date());
        if(personaDto.getUsername()==null)
            throw new UnprocessableEntityException("Campo nulo");
        if(personaDto.getUsername().length() > 10 || personaDto.getUsername().length() < 6)
            throw new UnprocessableEntityException("Campo usuario tiene que tener entre 6 y 10 caracteres");
        if(personaDto.getPassword()==null)
            throw new UnprocessableEntityException("Campo password no puede ser nulo");
        if(personaDto.getName()==null)
            throw new UnprocessableEntityException("Campo nombre no puede ser nulo");
        if(personaDto.getSurname()==null)
            throw new UnprocessableEntityException("Campo apellido no puede ser nulo");
        if(personaDto.getCity()==null)
            throw new UnprocessableEntityException("Campo ciudad no puede ser nulo");
        if(personaDto.getCompanyEmail()==null)
            throw new UnprocessableEntityException("Campo email  no puede ser nulo");
        if(!personaDto.getCompanyEmail().contains("@"))
            throw new UnprocessableEntityException("Campo email debe contener @");
        Persona personaEntity = PersonaMapper.Instance.personaInputDtoToPersona(personaDto) ;
        personaEntity= personaRepository.save(personaEntity);

        return PersonaMapper.Instance.personaToPersonaOutputDto(personaEntity);
    }

    @Override
    public List<PersonaOutputDto> getAll(){
       List<Persona> personList= personaRepository.findAll();
       List<PersonaOutputDto> personDtoList=new ArrayList<>();
       for(Persona person:personList){
           personDtoList.add(PersonaMapper.Instance.personaToPersonaOutputDto(person));
       }

       return personDtoList;


    }

    @Override
    public PersonaOutputDto getById(Long idPersona)throws EntityNotFoundException{

        Optional<Persona> personaOp=personaRepository.findById(idPersona);
        if(personaOp.isEmpty())
            throw new EntityNotFoundException("Persona no encontrada con ese id");

        return PersonaMapper.Instance.personaToPersonaOutputDto(personaOp.get());
    }

    @Override
    public PersonaOutputDto  getByUsername(String username){
        Persona persona=personaRepository.findByUsername(username);
        if(persona==null)
            throw new EntityNotFoundException("Persona no encontrada con ese usuario");

        return PersonaMapper.Instance.personaToPersonaOutputDto(persona);
    }

    @Override
    public String delete(Long idPersona) {
            Optional<Persona> personaOpt= personaRepository.findById(idPersona);
            if (personaOpt.isEmpty())
                throw new EntityNotFoundException("La persona con este id no existe");
            personaRepository.delete(personaOpt.get());

            return "La persona ha sido borrada";


    }

    @Override
    public PersonaOutputDto updatePersona(Long idPersona,PersonaInputDto personaDto)throws EntityNotFoundException,UnprocessableEntityException {
        Optional<Persona> personaOpt=personaRepository.findById(idPersona);
        if(personaOpt.isEmpty())
            throw new EntityNotFoundException("No existe la persona con este id");
        if(personaDto.getUsername()==null)
            throw new UnprocessableEntityException("Campo nulo");
        if(personaDto.getUsername().length() > 10 || personaDto.getUsername().length() < 6)
            throw new UnprocessableEntityException("Campo usuario tiene que tener entre 6 y 10 caracteres");
        if(personaDto.getPassword()==null)
            throw new UnprocessableEntityException("Campo password no puede ser nulo");
        if(personaDto.getName()==null)
            throw new UnprocessableEntityException("Campo nombre no puede ser nulo");
        if(personaDto.getSurname()==null)
            throw new UnprocessableEntityException("Campo apellido no puede ser nulo");
        if(personaDto.getCity()==null)
            throw new UnprocessableEntityException("Campo ciudad no puede ser nulo");
        if(personaDto.getCompanyEmail()==null)
            throw new UnprocessableEntityException("Campo email  no puede ser nulo");
        if(!personaDto.getCompanyEmail().contains("@"))
            throw new UnprocessableEntityException("Campo email debe contener @");

       Persona  personaSave=PersonaMapper.Instance.personaInputDtoToPersona(personaDto);
        personaSave.setIdPersona(idPersona);
        personaSave.setCreatedDate(personaOpt.get().getCreatedDate());
       personaSave= personaRepository.save(personaSave);

        return PersonaMapper.Instance.personaToPersonaOutputDto(personaSave);
    }

    @Override
    public Optional<Persona> getPersonaOptional(Long idPersona) {
        return personaRepository.findById(idPersona);
    }

    @Override
    public Page<PersonaOutputDtoNew> getData(PersonaPage page, PersonaSearchCriteria personaSearchCriteria) {

        Page<Persona> personPage = personaCriteriaRepository.findAllWithFilters(page,personaSearchCriteria);
        List<PersonaOutputDtoNew> personaOutputDtoList= personPage.getContent().stream().map(PersonaOutputDtoNew::new).toList();


        return new PageImpl<>(personaOutputDtoList,personPage.getPageable(),personPage.getTotalElements());
    }


}
