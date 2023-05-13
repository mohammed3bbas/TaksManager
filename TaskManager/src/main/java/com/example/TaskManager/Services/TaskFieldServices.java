package com.example.TaskManager.Services;

import com.example.TaskManager.DTOs.TaskFieldDTO;
import com.example.TaskManager.Entities.TaskField;
import com.example.TaskManager.Repo.TaskFieldRepo;
import com.example.TaskManager.Repo.TaskTypeRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskFieldServices {
    private final TaskFieldRepo taskFieldRepo;
    private final TaskTypeRepo taskTypeRepo;

    public TaskFieldServices(TaskFieldRepo taskFieldRepo, TaskTypeRepo taskTypeRepo) {
        this.taskFieldRepo = taskFieldRepo;
        this.taskTypeRepo = taskTypeRepo;
    }

    public TaskField createTaskField(TaskFieldDTO taskFieldDTO) {
        TaskField taskField = createTaskFieldFromDTO(taskFieldDTO);
        return taskFieldRepo.save(taskField);
    }

    public List<TaskField> getAllTaskFields(){
        return  taskFieldRepo.findAll();
    }

    public Optional<TaskField> findTaskFieldById(Long id){
        return taskFieldRepo.findById(id);
    }

    public TaskField updateTask(TaskFieldDTO taskFieldDTO){
        Optional<TaskField> targetTaskField = taskFieldRepo.findById(taskFieldDTO.getId());
        if(targetTaskField.isPresent()){
            return taskFieldRepo.save(createTaskFieldFromDTO(taskFieldDTO));
        }
        return null;
    }

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
        taskField.setTaskType(taskTypeRepo.findById(taskFieldDTO.getTaskTypeId()).get());
        return taskField;
    }
}
