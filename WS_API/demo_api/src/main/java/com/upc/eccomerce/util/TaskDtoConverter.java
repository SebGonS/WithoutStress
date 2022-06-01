package com.upc.eccomerce.util;

import com.upc.eccomerce.dto.TaskRequest;
import com.upc.eccomerce.dto.TaskResponse;
import com.upc.eccomerce.entities.Task;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskDtoConverter {

    private ModelMapper modelMapper;

    public TaskDtoConverter(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    public TaskResponse convertTaskToDto(Task task){
        return modelMapper.map(task, TaskResponse.class);
    }

    public List<TaskResponse> convertTaskToDto(List<Task> tasks){
        return tasks.stream()
                .map(task->convertTaskToDto(task))
                .collect(Collectors.toList());
    }

    public Task convertDtoToEntity(TaskRequest taskRequest) {
        return modelMapper.map(taskRequest, Task.class);
    }
}
