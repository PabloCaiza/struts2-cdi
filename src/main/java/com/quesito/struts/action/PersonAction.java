package com.quesito.struts.action;


import com.opensymphony.xwork2.Preparable;
import com.quesito.struts.model.Person;
import com.quesito.struts.service.PersonService;
import lombok.Data;
import org.apache.struts2.convention.annotation.*;
import javax.inject.Inject;
import java.util.List;


@Namespace("/")
@ResultPath("/WEB-INF/jsps")
@InterceptorRefs({@InterceptorRef("paramsPrepareParamsStack")})
@Data
public class PersonAction  implements Preparable {
    @Inject
    private PersonService personService;

    private List<Person> peopleList;
    private Person person;

    @Action(value = "index",results = {@Result(name = "success",location = "index.jsp")})
    public String getPeople(){
        peopleList=personService.getPeople();
        return "success";
    }
    @Action(value = "inputPerson",results = {@Result(name = "success",location = "save.jsp")})
    public String inputPerson(){
        return "success";
    }

    @Action(value = "save",results = {@Result(name = "success",type = "redirectAction",location = "index")})
    public String savePerson(){
        if(person.getId()==null){
            personService.createPerson(person);
        }else{
            personService.updatePerson(person);
        }

        return "success";
    }
    @Action(value = "delete",results = {@Result(name = "success",type = "redirectAction",location = "index")})
    public String deletePerson(){
        personService.deletePerson(person.getId());
        return "success";
    }


    @Override
    public void prepare() throws Exception {
        if(person!=null && person.getId()!=null){
            person=personService.getPersonById(person.getId());
        }
    }
}
