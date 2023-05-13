package com.example.TaskManager.Controllers;

import com.example.TaskManager.DTOs.TaskDTO;
import com.example.TaskManager.Entities.Task;
import com.example.TaskManager.Services.TaskServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskServices taskServices;


    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @GetMapping()
    public List<Task> getAllTasks(){
        List<Task> result = taskServices.getAllTasks();
        return result;
    }

    @PostMapping()
    public Task addTask(@RequestBody TaskDTO taskDTO){
        return taskServices.createTask(taskDTO);
    }
}
