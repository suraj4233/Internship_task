package com.oit;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	 @Autowired
	    private TaskRepository taskRepository;

	    public List<Task> getAllTasks() {
	        return taskRepository.findAll();
	    }

	    public Optional<Task> getTaskById(int id) {
	        return taskRepository.findById(id);
	    }

	    public Task createTask(Task task) {
	        return taskRepository.save(task);
	    }

	    public Task updateTask(int id, Task task) {
			 if (taskRepository.existsById(id)) {
		            task.setId(id);
		            return taskRepository.save(task);
		        }
		        return null; // Handle error if needed
		}
	    
	    public void deleteTask(int id) {
	        taskRepository.deleteById(id);
	    }

		

}