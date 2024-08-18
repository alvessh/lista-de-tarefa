package com.listatarefa.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.listatarefa.api.entity.Person;
import com.listatarefa.api.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepo;

	public List<Person> fetchAllPerson(){
		return personRepo.fetchAllPerson(); 
	}
	
	public Person updatePerson(Integer id, Person person) {
		
		Optional<Person> personOpt = personRepo.fetchAllPerson()
				.stream()
				.filter(p -> p.getId().equals(id))
				.findAny();
		
		if (personOpt.isPresent()) {
			Person personUpdated = personOpt.get();
			personUpdated.setName(person.getName());
			personUpdated.setMail(person.getMail());
			personUpdated.setAddress(person.getAddress());
			return personUpdated;
		}
		
		return null;
		
	}
	
	public Person createNewPerson(Person person) {
		Person personNew = new Person();
		personNew.setName(person.getName());
		personNew.setMail(person.getMail());
		personNew.setAddress(person.getAddress());

		person = personRepo.save(person);
		return person;
	}
	
	public void deleteTaskItem(Integer id) {
		personRepo.delete(id);
	}
}
