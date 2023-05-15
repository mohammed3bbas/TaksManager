package com.example.TaskManager.Services.Interfaces;

import com.example.TaskManager.DTOs.TaskFieldDTO;
import com.example.TaskManager.Entities.TaskField;

import java.util.List;
import java.util.Optional;

public interface TaskFieldService {
    TaskField createTaskField(TaskFieldDTO taskFieldDTO);

    List<TaskField> getAllTaskFields();

    Optional<TaskField> findTaskFieldById(Long id);

    TaskField updateTask(TaskFieldDTO taskFieldDTO);

    void deleteTaskFieldById(Long id);
}
