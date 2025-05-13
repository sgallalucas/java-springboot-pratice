package com.lucas.myapplication.controllers;

import com.lucas.myapplication.entities.Task;
import com.lucas.myapplication.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> insert(@RequestBody Task task) {
        task = taskService.insert(task);
        return ResponseEntity.ok().body(task);
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        List<Task> list = taskService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
