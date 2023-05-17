package com.example.TaskManager.Services;

import com.example.TaskManager.DTOs.TaskDTO;
import com.example.TaskManager.Entities.Task;
import com.example.TaskManager.Repo.TaskRepo;
import com.example.TaskManager.Repo.TaskTypeRepo;
import com.example.TaskManager.Entities.TaskType;
import com.example.TaskManager.Services.Interfaces.TaskService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;
    private final TaskTypeRepo taskTypeRepo;

    public TaskServiceImpl(TaskRepo taskRepo, TaskTypeRepo taskTypeRepo) {
        this.taskRepo = taskRepo;
        this.taskTypeRepo = taskTypeRepo;
    }

    @Override
    public Task createTask(TaskDTO taskDTO) {
        Task task = createTaskFromDTO(taskDTO);
        return taskRepo.save(task);
    }

    @Override
    public List<Task> getAllTasks(){
        return  taskRepo.findAll();
    }

    @Override
    public Optional<Task> findTaskById(Long id){
        return taskRepo.findById(id);
    }
    @Override
    public Task findTaskByName(String name){
        return taskRepo.findByName(name).get(0);
    }

    @Override
    public Task updateTask(TaskDTO taskDTO){
        Optional<Task> targetTask = taskRepo.findById(taskDTO.getId());
        if(targetTask.isPresent()){
            return taskRepo.save(createTaskFromDTO(taskDTO));
        }
        return null;
    }

    @Override
    public void deleteTaskById(Long id){
        taskRepo.deleteById(id);
    }

    @Override
    public List<Task> getTasksByTaskType(TaskType taskType) {
        return taskRepo.findByTaskType(taskType);
    }

    private Task createTaskFromDTO(TaskDTO taskDTO){
        Task task = new Task();
        if(taskDTO.getId() != null) {
            task.setId(taskDTO.getId());
        }
        task.setCreationDateToNow();
        task.setDueDate(LocalDate.parse(taskDTO.getDueDate()));
        task.setDescription(taskDTO.getDescription());
        task.setName(taskDTO.getName());
        task.setTaskType(taskTypeRepo.findById(taskDTO.getTaskTypeId()).get());
        return task;
    }

}
