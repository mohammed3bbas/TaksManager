package com.example.TaskManager.DTOs;

public class TaskFieldDTO {

    private String name;

    private String value;

    private Long taskTypeId;

    public TaskFieldDTO(String name, String value, Long taskTypeId) {
        this.name = name;
        this.value = value;
        this.taskTypeId = taskTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(Long taskTypeId) {
        this.taskTypeId = taskTypeId;
    }
}
