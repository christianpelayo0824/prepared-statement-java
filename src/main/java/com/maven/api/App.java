package com.maven.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.maven.api.model.Person;
import com.maven.api.service.PersonService;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws SQLException {

		PersonService personFacade = new PersonService();

		Person person = new Person();
		person.setPid(2);
		person.setFirstname("Christian");
		person.setLastname("Pelayo");
		person.setEmail("chan@123");
		personFacade.createPerson(person);

		List<Person> listPerson = new ArrayList<>();
		listPerson = personFacade.getAllPerson();
		for (Person personTest : listPerson) {
			System.out.println(personTest.toString());
		}
	}
}
