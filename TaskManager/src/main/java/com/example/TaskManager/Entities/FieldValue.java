package com.example.TaskManager.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "field_value")
public class FieldValue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_field_id")
    private TaskField taskField;

    private String field_value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaskField getTaskField() {
        return taskField;
    }

    public void setTaskField(TaskField taskField) {
        this.taskField = taskField;
    }

    public String getField_value() {
        return field_value;
    }

    public void setField_value(String field_value) {
        this.field_value = field_value;
    }
}