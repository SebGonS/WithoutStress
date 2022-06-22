package com.upc.eccomerce.controllers;

import com.upc.eccomerce.dto.TaskRequest;
import com.upc.eccomerce.dto.TaskResponse;
import com.upc.eccomerce.entities.Task;
import com.upc.eccomerce.services.TaskService;
import com.upc.eccomerce.util.TaskDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;
    private TaskDtoConverter converter;

    public TaskController(TaskService taskService, TaskDtoConverter converter){
        this.taskService = taskService;
        this.converter = converter;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest taskRequest){
        Task task = taskService.createdTask(taskRequest);
        return new ResponseEntity<>(converter.convertTaskToDto(task), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable("id") Integer id, @RequestBody TaskRequest taskRequest){
        Task task = taskService.updateTask(id,taskRequest);
        return new ResponseEntity<>(converter.convertTaskToDto(task), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id){
        taskService.deleteTask(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getById(@PathVariable("id") Integer id){
        Optional<Task> tasks = taskService.getById(id);
        return new ResponseEntity<>(converter.convertTaskToDto(tasks.get()), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> findAllTask(@RequestParam(required = false) String name){
        List<Task> tasks = new ArrayList<Task>();

        if(name == null)
            tasks=taskService.getAllTasks();
        else
            taskService.getAllTasksByName(name).forEach(tasks::add);

        if(tasks.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(converter.convertTaskToDto(tasks), HttpStatus.OK);
    }
}