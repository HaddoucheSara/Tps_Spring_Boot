package com.example.applicationCRUD.repository;

import com.example.applicationCRUD.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
