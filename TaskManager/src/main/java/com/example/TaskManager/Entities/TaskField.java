package com.example.TaskManager.Entities;

import javax.persistence.*;
@Entity
@Table(name = "task_field")
public class TaskField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String value;

    @ManyToOne
    @JoinColumn(name = "task_type_id")
    private TaskType taskType;

}

