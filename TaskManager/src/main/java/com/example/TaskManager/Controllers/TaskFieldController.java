package com.example.TaskManager.Controllers;

import com.example.TaskManager.DTOs.TaskFieldDTO;
import com.example.TaskManager.Entities.TaskField;
import com.example.TaskManager.Services.TaskFieldServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-field")
public class TaskFieldController {
    private final TaskFieldServices taskFieldServices;

    public TaskFieldController(TaskFieldServices taskFieldServices) {
        this.taskFieldServices = taskFieldServices;
    }


    @GetMapping()
    public List<TaskField> getAllTasks(){
        List<TaskField> result = taskFieldServices.getAllTaskFields();
        return result;
    }

    @PostMapping()
    public TaskField addTask(@RequestBody TaskFieldDTO taskFieldDTO){
        return taskFieldServices.createTaskField(taskFieldDTO);
    }
}
