package com.example.TaskManager.Controllers;

import com.example.TaskManager.DTOs.FieldValueDTO;
import com.example.TaskManager.Entities.FieldValue;
import com.example.TaskManager.Services.Interfaces.FieldValueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/field-value")
public class FieldValueController {

    private final FieldValueService fieldValueService;

    public FieldValueController(FieldValueService fieldValueService) {
        this.fieldValueService = fieldValueService;
    }


    @GetMapping()
    public List<FieldValue> getAllFieldValues(){
        List<FieldValue> result = fieldValueService.getAllFieldValues();
        return result;
    }

    @PostMapping()
    public FieldValue addFieldValue(@RequestBody FieldValueDTO fieldValueDTO){
        return fieldValueService.createFieldValue(fieldValueDTO);
    }
}
