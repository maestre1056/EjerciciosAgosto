package com.example.ej7.crudvalidation.persona.infraestructure.repository;

import com.example.ej7.crudvalidation.persona.domain.Persona;
import com.example.ej7.crudvalidation.persona.domain.PersonaPage;
import com.example.ej7.crudvalidation.persona.domain.PersonaSearchCriteria;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PersonaCriteriaRepository {

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public PersonaCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    // Paginación y filtrado
    public Page<Persona> findAllWithFilters(PersonaPage personaPage, PersonaSearchCriteria personaSearchCriteria) {

        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> personaRoot = criteriaQuery.from(Persona.class); // cogemos todas las filas de la tabla para comparar
        Predicate predicate = getPredicate(personaSearchCriteria,personaRoot);
        criteriaQuery.where(predicate);

        setOrder(personaPage,criteriaQuery,personaRoot);

        TypedQuery<Persona> typedQuery = entityManager.createQuery(criteriaQuery);//Se hace la query y luego se cambia el primer y maximo resultado
        typedQuery.setFirstResult(personaPage.getPageNumber() * personaPage.getPageSize());
        typedQuery.setMaxResults(personaPage.getPageSize());

        Pageable pageable = getPageable(personaPage);

        long personaCount = getPersonaCount(predicate);

        return new PageImpl<>(typedQuery.getResultList(),pageable,personaCount);
    }

    private Predicate getPredicate(PersonaSearchCriteria personaSearchCriteria, Root<Persona> personaRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if (Objects.nonNull(personaSearchCriteria.getUsername())) {
            predicates.add(criteriaBuilder.like(personaRoot.get("username"), "%" + personaSearchCriteria.getUsername() + "%"));
        }
        if (Objects.nonNull(personaSearchCriteria.getName())) {
            predicates.add(criteriaBuilder.like(personaRoot.get("username"), "%" + personaSearchCriteria.getUsername() + "%"));
        }
        if (Objects.nonNull(personaSearchCriteria.getSurname())) {
            predicates.add(criteriaBuilder.like(personaRoot.get("surname"), "%" + personaSearchCriteria.getSurname() + "%"));
        }
        if (Objects.nonNull(personaSearchCriteria.getCreatedDate())) {

            if (personaSearchCriteria.getDateCriteria() != null) {
                if (personaSearchCriteria.getDateCriteria().equals("prev"))
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(personaRoot.get("created_date"), personaSearchCriteria.getCreatedDate()));
            } else
                predicates.add(criteriaBuilder.lessThan(personaRoot.get("createdDate"), personaSearchCriteria.getCreatedDate()));

        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void setOrder(PersonaPage personaPage,CriteriaQuery<Persona> criteriaQuery, Root<Persona> personaRoot){
        criteriaQuery.orderBy(criteriaBuilder.asc(personaRoot.get(personaPage.getSortBy())));
    }
    private Pageable getPageable(PersonaPage personaPage){
        Sort sort = Sort.by(personaPage.getSortDirection(), personaPage.getSortBy());
        return PageRequest.of(personaPage.getPageNumber(), personaPage.getPageSize(), sort);
    }

    private long getPersonaCount(Predicate predicate){
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Persona> countRoot = countQuery.from(Persona.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);

        return entityManager.createQuery(countQuery).getSingleResult();
    }



}
