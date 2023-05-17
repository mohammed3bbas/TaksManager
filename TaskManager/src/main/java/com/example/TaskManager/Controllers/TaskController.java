package com.example.TaskManager.Controllers;

import com.example.TaskManager.DTOs.TaskDTO;
import com.example.TaskManager.Entities.Task;
import com.example.TaskManager.Entities.TaskType;
import com.example.TaskManager.Services.Interfaces.TaskService;
import com.example.TaskManager.Services.Interfaces.TaskTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskTypeService taskTypeService;


    public TaskController(TaskService taskService, TaskTypeService taskTypeService) {
        this.taskService = taskService;
        this.taskTypeService = taskTypeService;
    }

    @GetMapping()
    public List<Task> getAllTasks(){
        List<Task> result = taskService.getAllTasks();
        return result;
    }

    @PostMapping()
    public Task addTask(@RequestBody TaskDTO taskDTO){
        return taskService.createTask(taskDTO);
    }

    @GetMapping("/TaskType")
    public List<Task> getTasksByTaskType(@RequestParam Long id) {
        Optional<TaskType> taskType = taskTypeService.findTaskTypeById(id);
        return taskService.getTasksByTaskType(taskType.get());
    }
}
