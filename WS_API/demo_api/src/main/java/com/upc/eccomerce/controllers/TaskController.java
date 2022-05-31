package com.upc.eccomerce.controllers;

import com.upc.eccomerce.dto.TaskResponse;
import com.upc.eccomerce.entities.Task;
import com.upc.eccomerce.util.TaskDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.upc.eccomerce.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annulation")
public class TaskController {

    private TaskService taskService;
    private TaskDtoConverter converter;

    public TaskController(TaskService taskService, TaskDtoConverter converter){
            this.taskService = taskService;
            this.converter = converter;
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

    @GetMapping("/{id}")
    public ResponseEntity<List<TaskResponse>> findAllRecycles(@PathVariable Integer id){
        List<Task> tasks = (List<Task>) taskService.getTaskById(id);
        return new ResponseEntity<>(converter.convertTaskToDto(tasks), HttpStatus.OK);
    }
}
