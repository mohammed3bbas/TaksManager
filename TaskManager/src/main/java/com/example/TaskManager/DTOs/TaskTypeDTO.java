package com.example.TaskManager.DTOs;

import com.example.TaskManager.Entities.TaskType;

import java.io.Serializable;

public class TaskTypeDTO implements Serializable {

    private Long id;
    private String name;

    public TaskTypeDTO(Long id, String name) {
        id = this.id;
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
        return id;
    }

    public void setId(Long id) {
        id = id;
    }
}
