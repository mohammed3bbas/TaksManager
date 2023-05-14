package com.example.TaskManager.DTOs;

import java.io.Serializable;

public class FieldValueDTO implements Serializable {
    private Long id;

    private Long taskFieldId;

    private Long taskId;

    private String field_value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskFieldId() {
        return taskFieldId;
    }

    public void setTaskFieldId(Long taskFieldId) {
        this.taskFieldId = taskFieldId;
    }

    public String getField_value() {
        return field_value;
    }

    public void setField_value(String field_value) {
        this.field_value = field_value;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}
