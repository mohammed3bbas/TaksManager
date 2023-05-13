package com.example.TaskManager.Services;

import com.example.TaskManager.DTOs.TaskDTO;
import com.example.TaskManager.Entities.Task;
import com.example.TaskManager.Repo.TaskRepo;
import com.example.TaskManager.Repo.TaskTypeRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class TaskServices {
    private final TaskRepo taskRepo;
    private final TaskTypeRepo taskTypeRepo;

    public TaskServices(TaskRepo taskRepo, TaskTypeRepo taskTypeRepo) {
        this.taskRepo = taskRepo;
        this.taskTypeRepo = taskTypeRepo;
    }

    public Task createTask(TaskDTO taskDTO) {
        Task task = createTaskFromDTO(taskDTO);
        return taskRepo.save(task);
    }

    public List<Task> getAllTasks(){
        return  taskRepo.findAll();
    }

    public Optional<Task> findTaskById(Long id){
        return taskRepo.findById(id);
    }
    public Task findTaskByName(String name){
        return taskRepo.findByName(name).get(0);
    }

    public Task updateTask(TaskDTO taskDTO){
        Optional<Task> targetTask = taskRepo.findById(taskDTO.getId());
        if(targetTask.isPresent()){
            return taskRepo.save(createTaskFromDTO(taskDTO));
        }
        return null;
    }

    public void deleteTaskById(Long id){
        taskRepo.deleteById(id);
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
