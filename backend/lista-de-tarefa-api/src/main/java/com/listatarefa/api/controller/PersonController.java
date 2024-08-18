package com.listatarefa.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.listatarefa.api.entity.Person;
import com.listatarefa.api.entity.Task;
import com.listatarefa.api.service.PersonService;
import com.listatarefa.api.service.TaskService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	// Buscar a lista de pessoas
	@GetMapping("/api/person")
	public ResponseEntity<?> fetchAllPerson(){
		List<Person> personList = personService.fetchAllPerson();		
		return ResponseEntity.ok(personList);
		
	}
	
	//Criar uma nova pessoa
	@PostMapping("/api/person")
	public ResponseEntity<?> createNewPerson(@RequestBody Person person){
		Person personNew = personService.createNewPerson(person);

		return ResponseEntity.ok(personNew);
	}
	
	//Atualizando uma pessoa
	@PutMapping("/api/person/{id}")
	public ResponseEntity<?> updateTask(@PathVariable Integer id, @RequestBody Person person){
		Person updatedPerson = personService.updatePerson(id, person);

		return ResponseEntity.ok(updatedPerson); 
		
	}
	
	//deletando uma pessoa
	@DeleteMapping("/api/person/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable Integer id){
		personService.deleteTaskItem(id);
		
		return ResponseEntity.ok("Person deleted!");	
	}
}