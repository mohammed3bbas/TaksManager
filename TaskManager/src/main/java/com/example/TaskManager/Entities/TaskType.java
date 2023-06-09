package com.example.TaskManager.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task_type")
public class TaskType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "taskType", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TaskField> fields = new ArrayList<>();

    public TaskType() {
    }

    public TaskType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskField> getFields() {
        return fields;
    }

    public void setFields(List<TaskField> fields) {
        this.fields = fields;
    }
}
