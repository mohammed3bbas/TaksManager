package com.example.TaskManager.Repo;

import com.example.TaskManager.Entities.TaskField;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskFieldRepo extends JpaRepository<TaskField, Long> {
}
