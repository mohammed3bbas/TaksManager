package com.example.TaskManager.Services;

import com.example.TaskManager.DTOs.TaskFieldDTO;
import com.example.TaskManager.Entities.TaskField;
import com.example.TaskManager.Repo.TaskFieldRepo;
import com.example.TaskManager.Repo.TaskTypeRepo;
import com.example.TaskManager.Services.Interfaces.TaskFieldService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskFieldServiceImpl implements TaskFieldService {
    private final TaskFieldRepo taskFieldRepo;
    private final TaskTypeRepo taskTypeRepo;

    public TaskFieldServiceImpl(TaskFieldRepo taskFieldRepo, TaskTypeRepo taskTypeRepo) {
        this.taskFieldRepo = taskFieldRepo;
        this.taskTypeRepo = taskTypeRepo;
    }

    @Override
    public TaskField createTaskField(TaskFieldDTO taskFieldDTO) {
        TaskField taskField = createTaskFieldFromDTO(taskFieldDTO);
        return taskFieldRepo.save(taskField);
    }

    @Override
    public List<TaskField> getAllTaskFields(){
        return  taskFieldRepo.findAll();
    }

    @Override
    public Optional<TaskField> findTaskFieldById(Long id){
        return taskFieldRepo.findById(id);
    }

    @Override
    public TaskField updateTask(TaskFieldDTO taskFieldDTO){
        Optional<TaskField> targetTaskField = taskFieldRepo.findById(taskFieldDTO.getId());
        if(targetTaskField.isPresent()){
            return taskFieldRepo.save(createTaskFieldFromDTO(taskFieldDTO));
        }
        return null;
    }

    @Override
    public void deleteTaskFieldById(Long id){
        taskFieldRepo.deleteById(id);
    }

    private TaskField createTaskFieldFromDTO(TaskFieldDTO taskFieldDTO){
        TaskField taskField = new TaskField();
        if(taskFieldDTO.getId() != null) {
            taskField.setId(taskFieldDTO.getId());
        }
        taskField.setName(taskFieldDTO.getName());
        taskField.setFieldType(taskFieldDTO.getFieldType());
        taskField.setRequired(taskFieldDTO.getIsRequired());
        taskField.setTaskType(taskTypeRepo.findById(taskFieldDTO.getTaskTypeId()).get());
        return taskField;
    }
}
