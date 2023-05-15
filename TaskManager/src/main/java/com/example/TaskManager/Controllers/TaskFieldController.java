package com.example.TaskManager.Controllers;

import com.example.TaskManager.DTOs.TaskFieldDTO;
import com.example.TaskManager.Entities.TaskField;
import com.example.TaskManager.Services.Interfaces.TaskFieldService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-field")
public class TaskFieldController {
    private final TaskFieldService taskFieldService;

    public TaskFieldController(TaskFieldService taskFieldService) {
        this.taskFieldService = taskFieldService;
    }


    @GetMapping()
    public List<TaskField> getAllTasks(){
        List<TaskField> result = taskFieldService.getAllTaskFields();
        return result;
    }

    @PostMapping()
    public TaskField addTask(@RequestBody TaskFieldDTO taskFieldDTO){
        return taskFieldService.createTaskField(taskFieldDTO);
    }
}
