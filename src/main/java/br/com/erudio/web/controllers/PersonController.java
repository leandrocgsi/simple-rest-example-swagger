package br.com.erudio.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import br.com.erudio.models.Person;
import br.com.erudio.services.PersonService;


@Api(value = "person")
@RestController
@RequestMapping("/person/")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@ApiOperation(value = "Find person by ID" )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{personId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person get(@PathVariable(value = "personId") String personId){
        return personService.findById(personId);
    }
	
	@ApiOperation(value = "Find all persons" )
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll(){
		return personService.findAll();
	}
	
	@ApiOperation(value = "Create a new person" )
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person){
		return personService.create(person);
	}
	
	@ApiOperation(value = "Update an existing person")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person){
		return personService.update(person);
	}

	@ApiOperation(value = "Delete person by ID" )
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{personId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "personId") String personId){
        personService.delete(personId);
    }
	
}
