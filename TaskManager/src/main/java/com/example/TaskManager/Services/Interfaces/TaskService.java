package com.example.TaskManager.Services.Interfaces;

import com.example.TaskManager.DTOs.TaskDTO;
import com.example.TaskManager.Entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createTask(TaskDTO taskDTO);

    List<Task> getAllTasks();

    Optional<Task> findTaskById(Long id);

    Task findTaskByName(String name);

    Task updateTask(TaskDTO taskDTO);

    void deleteTaskById(Long id);
}
