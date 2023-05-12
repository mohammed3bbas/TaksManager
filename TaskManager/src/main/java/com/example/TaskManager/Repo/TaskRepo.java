package com.example.TaskManager.Repo;

import com.example.TaskManager.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TaskRepo extends JpaRepository<Task, Long> {
}
