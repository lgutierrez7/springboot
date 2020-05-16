package com.lgutierrez.crud.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lgutierrez.crud.dao.PersonDAO;
import com.lgutierrez.crud.model.Person;

@Service
public class PersonService {

	@Autowired
	@Qualifier("fakePersonDAO")
	private PersonDAO personDAO;
	
	public int addPerson(Person person) {
		return personDAO.insertPerson(person);
	}
	
	public List<Person> getAllPerson() {
		return personDAO.getAllPerson();
	}
	
	public Person getPersonByID(UUID id) {
		return personDAO.getPersonByID(id).orElse(null);
	}
	
	public int updatePerson(UUID id,Person person) {
		return personDAO.updatePersonByID(id, person);
	}
	
	public int deletePerson(UUID id) {
		return personDAO.deletePersonByID(id);
	}
	
}
