package com.example.TaskManager.Services;

import com.example.TaskManager.DTOs.TaskTypeDTO;
import com.example.TaskManager.Entities.TaskType;
import com.example.TaskManager.Repo.TaskTypeRepo;
import com.example.TaskManager.Services.Interfaces.TaskTypeService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskTypeServiceImpl implements TaskTypeService {
    private final TaskTypeRepo taskTypeRepo;

    public TaskTypeServiceImpl(TaskTypeRepo taskTypeRepo) {
        this.taskTypeRepo = taskTypeRepo;
    }

    @Override
    public TaskType createTaskType(TaskTypeDTO taskTypeDTO) {
        TaskType taskType = createTaskTypeFromDTO(taskTypeDTO);
        return taskTypeRepo.save(taskType);
    }

    @Override
    public List<TaskType> getAllTaskTypes(){
        return  taskTypeRepo.findAll();
    }

    @Override
    public Optional<TaskType> findTaskTypeById(Long id){
        return taskTypeRepo.findById(id);
    }

    @Override
    public TaskType updateTaskType(TaskTypeDTO taskTypeDTO){
        Optional<TaskType> targetTaskType = taskTypeRepo.findById(taskTypeDTO.getId());
        if(targetTaskType.isPresent()){
            return taskTypeRepo.save(createTaskTypeFromDTO(taskTypeDTO));
        }
        return null;
    }

    @Override
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
