package com.example.TaskManager.Repo;

import com.example.TaskManager.Entities.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskTypeRepo extends JpaRepository<TaskType , Long> {
}
