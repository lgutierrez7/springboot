package com.lgutierrez.crud.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
*/

import lombok.Data;

//@Entity
@Data
/*
@NoArgsConstructor
@AllArgsConstructor*/
public class Person {

	private UUID id;
	
	@NotNull
	@Size(min = 2, max = 50)
	private String name;

	
	
	public Person(UUID id, @NotNull @Size(min = 2, max = 50) String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
