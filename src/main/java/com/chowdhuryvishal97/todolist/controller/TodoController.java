package com.chowdhuryvishal97.todolist.controller;

import com.chowdhuryvishal97.todolist.model.Todo;
import com.chowdhuryvishal97.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    // Display all data in todo table
    @GetMapping("/")
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    /**
     * POST request that adds a task in todo table
     * sample post json body:
     * {
     * "task": "Sample task",
     * "completed": false
     * }
     */
    @PostMapping("/")
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    /**
     * PUT request that updates task in todo with the given id
     * Format for request body
     * {
     * "task": "Sample task updated",
     * "completed": false
     * }
     * if not found return 404
     */
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));

        todo.setTask(todoDetails.getTask());
        todo.setCompleted(todoDetails.isCompleted());

        return todoRepository.save(todo);
    }

    /**
     * DELETE request to remove data by the given id in todo table
     * if not found return 404
     */
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        todoRepository.deleteById(id);
    }
}
