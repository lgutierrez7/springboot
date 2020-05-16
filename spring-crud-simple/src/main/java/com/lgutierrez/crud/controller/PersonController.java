package com.lgutierrez.crud.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgutierrez.crud.model.Person;
import com.lgutierrez.crud.service.PersonService;


@RestController()
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping()
	public void addPerson(@RequestBody @Validated Person person) {
		personService.addPerson(person);
	}
	
	@GetMapping()
	public List<Person> getAllPerson() {
		return personService.getAllPerson();
	}
	
	@GetMapping(path="{id}")
	public Person getPerson(@PathVariable("id") UUID id) {
		return personService.getPersonByID(id);
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
