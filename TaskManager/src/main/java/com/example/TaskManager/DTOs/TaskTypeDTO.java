package com.example.TaskManager.DTOs;

import com.example.TaskManager.Entities.TaskType;

import java.io.Serializable;

public class TaskTypeDTO implements Serializable {

    private Long Id;
    private String name;

    public TaskTypeDTO(Long id, String name) {
        Id = id;
        this.name = name;
    }

    public TaskTypeDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
