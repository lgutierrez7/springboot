package com.lgutierrez.crud.controller;

import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgutierrez.crud.exception.ResourceNotFoundException;
import com.lgutierrez.crud.model.Person;
import com.lgutierrez.crud.service.PersonService;


@RestController()
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping()
	public ResponseEntity<String> addPerson(@RequestBody @Validated Person person) {
		personService.addPerson(person);
		return ResponseEntity.ok("Person was created");
	}
	
	@GetMapping()
	public List<Person> getAllPerson() {
		return personService.getAllPerson();
	}
	
	@GetMapping(path="{id}")
	public Person getPerson(@PathVariable("id") UUID id) {
		Person person = personService.getPersonByID(id);
		if(person==null) {
			throw new ResourceNotFoundException();
		}
		return person;
	}
	
	@PutMapping(path="{id}")
	public void updatePerson(
			@PathVariable("id") UUID id,
			@RequestBody Person person) {
		personService.updatePerson(id,person);
	}
	
	@DeleteMapping(path="{id}")
	public void deletePerson(@PathVariable("id") UUID id) {
		personService.deletePerson(id);
	}
}
