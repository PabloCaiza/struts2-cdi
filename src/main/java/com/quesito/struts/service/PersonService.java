package com.quesito.struts.service;

import com.quesito.struts.model.Person;

import java.util.List;

public interface PersonService {

    Person getPersonById(Integer id);
    List<Person> getPeople();
    void createPerson(Person person);
    void deletePerson(Integer id);
    void updatePerson(Person person);

}
