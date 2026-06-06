package com.project.TaskManager.Controller;

import com.project.TaskManager.entity.Todo;
import com.project.TaskManager.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {


    private final TodoService service;

    public TodoController(TodoService service){
        this.service = service;
    }

    @PostMapping
    public Todo addTodo(@RequestBody @Valid Todo todo){
        return service.addTodo(todo);
    }


    @GetMapping("{id}")
    public Todo getTodoById(@PathVariable Integer id){
        return service.getTodoById(id);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Integer id,@RequestBody @Valid Todo todoData){
        return service.updateTodo(id,todoData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Integer id){
        service.deleteTodo(id);
        return ResponseEntity.ok("Todo deleted successfully");
    }

    @GetMapping("/status/completed")
    public List<Todo> completedTodos(){
        return service.getTodoByStatus(Todo.Status.COMPLETED);
    }

    @GetMapping("/status/pending")
    public List<Todo> pendingTodos(){
        return service.getTodoByStatus(Todo.Status.PENDING);
    }

    @GetMapping
    public Page<Todo> getAllTodos(Pageable pageable){
        return service.getAllTodos(pageable);
    }
}
