package com.maven.api.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.maven.api.config.DatabaseConfig;
import com.maven.api.facade.PersonFacade;
import com.maven.api.model.Person;

public class PersonService implements PersonFacade {

	private static final Logger LOGGER = Logger.getLogger(PersonFacade.class.getName());
	private DatabaseConfig dbConfig = new DatabaseConfig();

	@Override
	public boolean createPerson(Person person) {
		boolean rowStatus = false;
		try {
			String query = "INSERT INTO person(pid, firstname, lastname, email) VALUES (?, ? , ?, ?)";
			dbConfig.connect();
			PreparedStatement statement = dbConfig.getConnection().prepareStatement(query);
			statement.setInt(1, person.getPid());
			statement.setString(2, person.getFirstname());
			statement.setString(3, person.getLastname());
			statement.setString(4, person.getEmail());
			rowStatus = statement.executeUpdate() > 0;
			LOGGER.log(Level.INFO, "Person Created!");
			dbConfig.closeConnection();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		return rowStatus;
	}

	@Override
	public List<Person> getAllPerson() {
		List<Person> listPerson = new ArrayList<>();
		try {
			String query = "SELECT * FROM person";
			dbConfig.connect();
			Statement stmt = dbConfig.getStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int pid = rs.getInt("pid");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				Person person = new Person(pid, firstname, lastname, email);
				listPerson.add(person);
				rs.close();
				dbConfig.closeConnection();
			}

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		return listPerson;
	}

}
