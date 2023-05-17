package com.example.TaskManager.Controllers;

import com.example.TaskManager.DTOs.TaskTypeDTO;
import com.example.TaskManager.Entities.TaskType;
import com.example.TaskManager.Services.Interfaces.TaskTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-types")
public class TaskTypeController {
    private final TaskTypeService taskTypeService;

    public TaskTypeController(TaskTypeService taskTypeService) {
        this.taskTypeService = taskTypeService;
    }

    @GetMapping()
    public List<TaskType> getAllTasks(){
        List<TaskType> result = taskTypeService.getAllTaskTypes();
        return result;
    }

    @PostMapping()
    public TaskType addTaskType(@RequestBody TaskTypeDTO taskTypeDTO){
        return taskTypeService.createTaskType(taskTypeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTaskTypeById(@PathVariable Long id){
        taskTypeService.deleteTaskTypeById(id);
    }
}
