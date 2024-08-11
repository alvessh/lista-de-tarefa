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

import com.listatarefa.api.entity.Task;
import com.listatarefa.api.service.TaskService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	// Buscar a lista de tarefas
	@GetMapping("/api/task")
	public ResponseEntity<?> fetchAllTask(){
		List<Task> taskList = taskService.fetchAllTask();		
		return ResponseEntity.ok(taskList);
		
	}
	
	//Criar uma nova tarefa
	@PostMapping("/api/task")
	public ResponseEntity<?> createNewTask(){
		Task task = taskService.createNewTaskItem();

		return ResponseEntity.ok(task);
	}
	
	//Atualizando a tarefa
	@PutMapping("/api/task/{id}")
	public ResponseEntity<?> updateTask(@PathVariable Integer id, @RequestBody Task task){
		Task updatedTask = taskService.updateTaskItem(id, task);

		return ResponseEntity.ok(updatedTask); 
		
	}
	
	//deletando a tarefa
	@DeleteMapping("/api/task/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable Integer id){
		taskService.deleteTaskItem(id);
		
		return ResponseEntity.ok("Task deleted!");	
	}
}