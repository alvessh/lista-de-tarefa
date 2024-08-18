package com.listatarefa.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.listatarefa.api.entity.Person;

@Repository
public class PersonRepository {
	private Integer idCounter =0;
	private List<Person> personList = new ArrayList<>();
	
	public List<Person> fetchAllPerson(){
		return personList;
		 
	}
	
	public Person save (Person person) {
		person.setId(idCounter++);
		personList.add(person); 
		return person;
		
	}
	
	public void delete(Integer id) {
		personList = personList.stream()
				 .filter(person -> !person.getId().equals(id))
				 .collect(Collectors.toList());
	}
}