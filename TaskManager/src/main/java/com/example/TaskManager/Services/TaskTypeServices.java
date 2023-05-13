package com.example.TaskManager.Services;

import com.example.TaskManager.DTOs.TaskTypeDTO;
import com.example.TaskManager.Entities.TaskType;
import com.example.TaskManager.Repo.TaskTypeRepo;

import java.util.List;
import java.util.Optional;

public class TaskTypeServices {
    private final TaskTypeRepo taskTypeRepo;

    public TaskTypeServices(TaskTypeRepo taskTypeRepo) {
        this.taskTypeRepo = taskTypeRepo;
    }

    public TaskType createTaskType(TaskTypeDTO taskTypeDTO) {
        TaskType taskType = createTaskTypeFromDTO(taskTypeDTO);
        return taskTypeRepo.save(taskType);
    }

    public List<TaskType> getAllTaskTypes(){
        return  taskTypeRepo.findAll();
    }

    public Optional<TaskType> findTaskTypeById(Long id){
        return taskTypeRepo.findById(id);
    }

    public TaskType updateTaskType(TaskTypeDTO taskTypeDTO){
        Optional<TaskType> targetTaskType = taskTypeRepo.findById(taskTypeDTO.getId());
        if(targetTaskType.isPresent()){
            return taskTypeRepo.save(createTaskTypeFromDTO(taskTypeDTO));
        }
        return null;
    }

    public void deleteTaskTypeById(Long id){
        taskTypeRepo.deleteById(id);
    }


    private TaskType createTaskTypeFromDTO(TaskTypeDTO taskTypeDTO){
        TaskType taskType = new TaskType();
        if(taskTypeDTO.getId() !=null){
            taskType.setId(taskTypeDTO.getId());
        }
        taskType.setName(taskTypeDTO.getName());
        return taskType;
    }
}
