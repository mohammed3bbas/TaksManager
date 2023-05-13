package com.example.TaskManager.DTOs;

public class TaskTypeDTO {

    private String name;

    public TaskTypeDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
