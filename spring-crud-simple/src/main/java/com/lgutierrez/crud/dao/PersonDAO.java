package com.lgutierrez.crud.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.lgutierrez.crud.model.Person;

public interface PersonDAO {

	int insertPerson(UUID id, Person person);
	
	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}
	
	List<Person> getAllPerson();
	
	Optional<Person> getPersonByID(UUID id);
	
	int updatePersonByID(UUID id, Person person);
	
	int deletePersonByID(UUID id);
	
}

