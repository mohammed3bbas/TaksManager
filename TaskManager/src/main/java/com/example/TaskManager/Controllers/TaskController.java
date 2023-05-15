package com.example.TaskManager.Controllers;

import com.example.TaskManager.DTOs.TaskDTO;
import com.example.TaskManager.Entities.Task;
import com.example.TaskManager.Services.Interfaces.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
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
}
