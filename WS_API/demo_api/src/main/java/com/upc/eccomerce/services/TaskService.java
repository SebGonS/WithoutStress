package com.upc.eccomerce.services;

import com.upc.eccomerce.dto.TaskRequest;
import com.upc.eccomerce.entities.Task;
import com.upc.eccomerce.exception.TaskNotFoundException;
import com.upc.eccomerce.repository.TaskRepository;
import com.upc.eccomerce.util.TaskDtoConverter;
import com.upc.eccomerce.validator.TaskValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private TaskDtoConverter converter;

    public TaskService(TaskRepository taskRepository, TaskDtoConverter converter){
        this.taskRepository = taskRepository;
        this.converter=converter;
    }

    @Transactional
    public List<Task> findAllTask(){
        return taskRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Task> getAllTasks(){
        return  taskRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Task> getAllTasksByName(String name){
        return  taskRepository.findByNameContaining(name);
    }

    @Transactional(readOnly = true)
    public Task getTaskById(Integer id){
        return taskRepository.findTaskById(id);
    }
    @Transactional(readOnly = true)
    public Optional getById(Integer id){
        return Optional.ofNullable(taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Tarea no existe")));
    }
    public Task createdTask(TaskRequest taskRequest){
        TaskValidator.validate(taskRequest);
        Task task=converter.convertDtoToEntity(taskRequest);
        return taskRepository.save(task);
    }

    public Task updateTask(Integer id, TaskRequest taskRequest){
        TaskValidator.validate(taskRequest);

        Task taskFromDb = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Actividad no existe"));

        taskFromDb.setName(taskRequest.getName());
        taskFromDb.setSummary(taskRequest.getSummary());
        taskFromDb.setUser_id(taskRequest.getUser_id());

        return taskRepository.save(taskFromDb);
    }
    @Transactional
    public void deleteTask(Integer taskId){

        Task task = this.getTaskById(taskId);

        taskRepository.delete(task);
    }
}
