package com.example.TaskManager.Controllers;

import com.example.TaskManager.DTOs.TaskTypeDTO;
import com.example.TaskManager.Entities.TaskType;
import com.example.TaskManager.Services.TaskTypeServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-types")
public class TaskTypeController {
    private final TaskTypeServices taskTypeServices;

    public TaskTypeController(TaskTypeServices taskTypeServices) {
        this.taskTypeServices = taskTypeServices;
    }

    @GetMapping()
    public List<TaskType> getAllTasks(){
        List<TaskType> result = taskTypeServices.getAllTaskTypes();
        return result;
    }

    @PostMapping()
    public TaskType addTaskType(@RequestBody TaskTypeDTO taskTypeDTO){
        return taskTypeServices.createTaskType(taskTypeDTO);
    }
}
