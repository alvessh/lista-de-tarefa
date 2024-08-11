package com.listatarefa.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.listatarefa.api.entity.Task;

@Repository
public class TaskRepository {
	private Integer idCounter =0;
	private List<Task> taskList = new ArrayList<>();
	
	public List<Task> fetchAllTask(){
		if (taskList.size() == 0) {
			Task task1 = new Task();
			task1.setIsDone(false);
			task1.setDescription("Clique aqui para editar a tarefa.");
			task1.setId(idCounter++);
			
			taskList.add(task1);
			
		}
		return taskList;
		 
	}
	
	public Task save (Task todoItem) {
		todoItem.setId(idCounter++);
		taskList.add(todoItem); 
		return todoItem;
		
	}
	
	public void delete(Integer id) {
		taskList = taskList.stream()
				 .filter(task -> !task.getId().equals(id))
				 .collect(Collectors.toList());
	}
}
