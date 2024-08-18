package com.listatarefa.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.listatarefa.api.entity.Task;
import com.listatarefa.api.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepo;

	public List<Task> fetchAllTask(){
		return taskRepo.fetchAllTask(); 
	}
	
	public Task updateTaskItem(Integer id, Task taskItem) {
		
		Optional<Task> taskOpt = taskRepo.fetchAllTask()
				.stream()
				.filter(item -> item.getId().equals(id))
				.findAny();
		
		if (taskOpt.isPresent()) {
			Task task = taskOpt.get();
			task.setIsDone(taskItem.getIsDone());
			task.setDescription(taskItem.getDescription());
			
			return task;
		}
		
		return null;
		
	}
	
	public Task createNewTaskItem() {
		Task taskItem = new Task();
		taskItem.setIsDone(false);
		
		taskItem = taskRepo.save(taskItem);
		taskItem.setDescription("Clique aqui para editar a tarefa.");
		return taskItem;
	}
	
	public void deleteTaskItem(Integer id) {
		taskRepo.delete(id);
	}
}
