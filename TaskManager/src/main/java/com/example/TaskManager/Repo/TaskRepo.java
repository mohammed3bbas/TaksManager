package com.example.TaskManager.Repo;

import com.example.TaskManager.Entities.Task;
import com.example.TaskManager.Entities.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> findByName(String name);
    List<Task> findByTaskType(TaskType taskType);
}
