package com.quesito.struts.repository;

import com.quesito.struts.model.Person;

import java.util.List;

public interface PersonRepository {

    List<Person> getPeople();
    void createPerson(Person person);
    void update(Person person);
    void deletePerson(Integer id);
    Person getPersonById(Integer id);

}
