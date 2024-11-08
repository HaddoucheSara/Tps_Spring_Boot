package com.example.applicationCRUD.service;

import com.example.applicationCRUD.model.Task;
import com.example.applicationCRUD.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service

public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask (Task task) {
        task.setCreationDate(new Date());
        return taskRepository.save(task);
    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public Task getTaskById(long id) {
        return taskRepository.findById(id).orElse(null);
    }
    public Task updateTask(long id, Task updatedTask) {
       Optional<Task> optionaltask = taskRepository.findById(id);
       if(optionaltask.isPresent()) {
           Task existingtask = optionaltask.get();
           existingtask.setDescription(updatedTask.getDescription());
           existingtask.setDueDate(updatedTask.getDueDate());
        return taskRepository.save(existingtask);
       }
       return null;
    }
    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }
}
