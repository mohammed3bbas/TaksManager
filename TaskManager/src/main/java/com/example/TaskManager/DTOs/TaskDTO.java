package com.example.TaskManager.DTOs;

public class TaskDTO {

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
}
