package com.upc.eccomerce.controllers;

import com.upc.eccomerce.entities.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.upc.eccomerce.services.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/annulation")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService){
            this.taskService = taskService;
        }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return new ResponseEntity<Task>(taskService.createdTask(task), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        return new ResponseEntity<Task>(taskService.createdTask(task), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id){
        taskService.deleteTask(id);
    }

}
