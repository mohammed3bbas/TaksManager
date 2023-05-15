package com.example.TaskManager.Services;

import com.example.TaskManager.DTOs.FieldValueDTO;
import com.example.TaskManager.Entities.FieldValue;
import com.example.TaskManager.Repo.FieldValueRepo;
import com.example.TaskManager.Repo.TaskFieldRepo;
import com.example.TaskManager.Repo.TaskRepo;
import com.example.TaskManager.Services.Interfaces.FieldValueService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FieldValueServiceImpl implements FieldValueService {
    private final FieldValueRepo fieldValueRepo;
    private final TaskFieldRepo taskFieldRepo;
    private final TaskRepo taskRepo;


    public FieldValueServiceImpl(FieldValueRepo fieldValueRepo, TaskFieldRepo taskFieldRepo, TaskRepo taskRepo) {
        this.fieldValueRepo = fieldValueRepo;
        this.taskFieldRepo = taskFieldRepo;
        this.taskRepo = taskRepo;
    }

    @Override
    public FieldValue createFieldValue(FieldValueDTO fieldValueDTO) {
        FieldValue fieldValue = createFieldValueFromDTO(fieldValueDTO);
        return fieldValueRepo.save(fieldValue);
    }

    @Override
    public List<FieldValue> getAllFieldValues(){
        return  fieldValueRepo.findAll();
    }

    @Override
    public Optional<FieldValue> findFieldValueById(Long id){
        return fieldValueRepo.findById(id);
    }

    @Override
    public FieldValue updateFieldValue(FieldValueDTO fieldValueDTO){
        Optional<FieldValue> targetFieldValue = fieldValueRepo.findById(fieldValueDTO.getId());
        if(targetFieldValue.isPresent()){
            return fieldValueRepo.save(createFieldValueFromDTO(fieldValueDTO));
        }
        return null;
    }

    @Override
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
        fieldValue.setTask(taskRepo.findById(fieldValueDTO.getTaskId()).get());
        return fieldValue;
    }
}
