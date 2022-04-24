package com.quesito.struts.service;


import com.quesito.struts.model.Person;
import com.quesito.struts.repository.PersonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;


@ApplicationScoped
public class PersonServiceImpl implements PersonService {
    @Inject
    private PersonRepository personRepository;
    @Override
    public Person getPersonById(Integer id) {
        return personRepository.getPersonById(id);
    }

    @Override
    public List<Person> getPeople() {
        return personRepository.getPeople();
    }

    @Override
    public void createPerson(Person person) {
        personRepository.createPerson(person);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepository.deletePerson(id);
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.update(person);
    }
}
