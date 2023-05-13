package com.example.TaskManager.Services;

import com.example.TaskManager.DTOs.FieldValueDTO;
import com.example.TaskManager.Entities.FieldValue;
import com.example.TaskManager.Entities.TaskField;
import com.example.TaskManager.Repo.FieldValueRepo;
import com.example.TaskManager.Repo.TaskFieldRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FieldValueServices {
    private final FieldValueRepo fieldValueRepo;
    private final TaskFieldRepo taskFieldRepo;


    public FieldValueServices(FieldValueRepo fieldValueRepo, TaskFieldRepo taskFieldRepo) {
        this.fieldValueRepo = fieldValueRepo;
        this.taskFieldRepo = taskFieldRepo;
    }

    public FieldValue createFieldValue(FieldValueDTO fieldValueDTO) {
        FieldValue fieldValue = createFieldValueFromDTO(fieldValueDTO);
        return fieldValueRepo.save(fieldValue);
    }

    public List<FieldValue> getAllFieldValues(){
        return  fieldValueRepo.findAll();
    }

    public Optional<FieldValue> findFieldValueById(Long id){
        return fieldValueRepo.findById(id);
    }

    public FieldValue updateFieldValue(FieldValueDTO fieldValueDTO){
        Optional<FieldValue> targetFieldValue = fieldValueRepo.findById(fieldValueDTO.getId());
        if(targetFieldValue.isPresent()){
            return fieldValueRepo.save(createFieldValueFromDTO(fieldValueDTO));
        }
        return null;
    }

    public void deleteFieldValueById(Long id){
        fieldValueRepo.deleteById(id);
    }

    private FieldValue createFieldValueFromDTO(FieldValueDTO fieldValueDTO){
        FieldValue fieldValue = new FieldValue();
        if(fieldValueDTO.getId() != null) {
            fieldValue.setId(fieldValueDTO.getId());
        }
        fieldValue.setField_value(fieldValueDTO.getField_value());
        fieldValue.setTaskField(taskFieldRepo.findById(fieldValueDTO.getTaskFieldId()).get());
        return fieldValue;
    }
}
