package com.example.TaskManager.Services.Interfaces;

import com.example.TaskManager.DTOs.TaskTypeDTO;
import com.example.TaskManager.Entities.TaskType;

import java.util.List;
import java.util.Optional;

public interface TaskTypeService {
    TaskType createTaskType(TaskTypeDTO taskTypeDTO);

    List<TaskType> getAllTaskTypes();

    Optional<TaskType> findTaskTypeById(Long id);

    TaskType updateTaskType(TaskTypeDTO taskTypeDTO);

    void deleteTaskTypeById(Long id);
}
