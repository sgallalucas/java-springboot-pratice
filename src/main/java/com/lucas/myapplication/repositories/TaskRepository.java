package com.lucas.myapplication.repositories;

import com.lucas.myapplication.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
