package com.upc.eccomerce.services;

import com.upc.eccomerce.entities.Task;
import com.upc.eccomerce.exception.OrderNotFoundException;
import com.upc.eccomerce.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Transactional(readOnly = true)
    public Task getTaskById(Integer id){
        return taskRepository.findTaskById(id);
    }

    public Task createdTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTask(Task task){

        Task taskFromDb = this.getTaskById(task.getId());

        taskFromDb.setId(task.getId());
        taskFromDb.setName(task.getName());
        taskFromDb.setSummary(task.getSummary());
        taskFromDb.setUser_id(task.getUser_id());

        return taskRepository.save(task);
    }
    @Transactional
    public void deleteTask(Integer taskId){

        Task task = this.getTaskById(taskId);

        taskRepository.delete(task);
    }
}
