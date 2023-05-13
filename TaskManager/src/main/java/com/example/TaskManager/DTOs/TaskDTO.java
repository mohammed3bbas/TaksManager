package com.example.TaskManager.DTOs;

import com.example.TaskManager.Entities.Task;

import java.time.LocalDate;

public class TaskDTO {
    private Long id;
    private String name;
    private String description;
    private String dueDate;
    private Long taskTypeId;

    public TaskDTO(String name, String description, String dueDate, Long taskTypeId) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.taskTypeId = taskTypeId;
    }

    public TaskDTO(Long id, String name, String description, String dueDate, Long taskTypeId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.taskTypeId = taskTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Long getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(Long taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Task createTask(TaskDTO taskDTO){
        Task task = new Task();
        if(taskDTO.getId() != null){
            task.setId(taskDTO.getId());
        }
        task.setCreationDateToNow();
        task.setDueDate(LocalDate.parse(taskDTO.getDueDate()));
        task.setDescription(taskDTO.getDescription());
        task.setName(taskDTO.getName());
        return task;
    }
}
