package com.maven.api.facade;

import java.util.List;

import com.maven.api.model.Person;

public interface PersonFacade {

	public boolean createPerson(Person person);

	public List<Person> getAllPerson();
}
