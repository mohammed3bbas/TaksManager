package com.example.TaskManager.Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDate dueDate;

    private  LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "task_type_id")
    private TaskType taskType;

    // constructors, getters, and setters
}

