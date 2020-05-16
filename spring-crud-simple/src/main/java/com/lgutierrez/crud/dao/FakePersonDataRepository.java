package com.lgutierrez.crud.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.lgutierrez.crud.model.Person;

@Repository("fakePersonDAO")
public class FakePersonDataRepository implements PersonDAO {

	private static List<Person> DB  = new ArrayList<>();

	@Override
	public int insertPerson(UUID id, Person person) {
		DB.add(new Person(id, person.getName()));
		return 1;
	}

	@Override
	public List<Person> getAllPerson() {
		// TODO Auto-generated method stub
		return DB;
	}

	@Override
	public Optional<Person> getPersonByID(UUID id) {
		// TODO Auto-generated method stub
		return DB.stream()
				.filter(person -> person.getId().equals(id))
				.findFirst();
	}

	@Override
	public int updatePersonByID(UUID id, Person person) {
		return getPersonByID(id)
			.map( personDB -> {
				int indexOfPersonToDelete = DB.indexOf(personDB);
				if(indexOfPersonToDelete>=0) {
					DB.set(indexOfPersonToDelete, new Person(id, person.getName()));
					return 1;
				}
				return 0;
			}).orElse(0);
		
	}

	@Override
	public int deletePersonByID(UUID id) {
		
		Optional<Person> personMaybe= getPersonByID(id);
		if(personMaybe.isPresent()) {
			DB.remove(personMaybe.get());
			return 1;
		}
		// TODO Auto-generated method stub
		return 0;
	}
	
}
