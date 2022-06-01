package com.upc.eccomerce.validator;

import com.upc.eccomerce.dto.TaskRequest;
import com.upc.eccomerce.exception.IncorrectOrderRequestException;

public class TaskValidator {
    public static  void validate(TaskRequest taskRequest){
        if(taskRequest.getUser_id() == null) {
            throw new IncorrectOrderRequestException("El código es requerido");
        }

        if(taskRequest.getName() == null || taskRequest.getName().trim().isEmpty()) {
            throw new IncorrectOrderRequestException("El titulo es requerido");
        }

        if(taskRequest.getSummary() == null || taskRequest.getSummary().trim().isEmpty()) {
            throw new IncorrectOrderRequestException("La descripción es requerido");
        }
    }
}
