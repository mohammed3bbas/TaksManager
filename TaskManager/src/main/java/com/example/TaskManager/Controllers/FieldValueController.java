package com.example.TaskManager.Controllers;

import com.example.TaskManager.DTOs.FieldValueDTO;
import com.example.TaskManager.DTOs.TaskDTO;
import com.example.TaskManager.Entities.FieldValue;
import com.example.TaskManager.Entities.Task;
import com.example.TaskManager.Services.FieldValueServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/field-value")
public class FieldValueController {

    private final FieldValueServices fieldValueServices;

    public FieldValueController(FieldValueServices fieldValueServices) {
        this.fieldValueServices = fieldValueServices;
    }


    @GetMapping()
    public List<FieldValue> getAllTasks(){
        List<FieldValue> result = fieldValueServices.getAllFieldValues();
        return result;
    }

    @PostMapping()
    public FieldValue addTask(@RequestBody FieldValueDTO fieldValueDTO){
        return fieldValueServices.createFieldValue(fieldValueDTO);
    }
}
