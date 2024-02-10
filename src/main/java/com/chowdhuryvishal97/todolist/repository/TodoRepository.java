package com.chowdhuryvishal97.todolist.repository;

import com.chowdhuryvishal97.todolist.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
