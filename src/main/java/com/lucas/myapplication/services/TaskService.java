package com.lucas.myapplication.services;

import com.lucas.myapplication.entities.Task;
import com.lucas.myapplication.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task insert(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task update(Long id, Task task) {
        try {
            Task updatedTask = taskRepository.getReferenceById(id);
            updateTask(updatedTask, task);
            return taskRepository.save(updatedTask);
        }
        catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    public void updateTask (Task updatedTask, Task task) {
        updatedTask.setTaskName(task.getTaskName());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setStatus(task.isStatus());
    }

    public void delete(Long id){
        try {
            if (taskRepository.existsById(id)){
                taskRepository.deleteById(id);
            }
        }
        catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }
}
