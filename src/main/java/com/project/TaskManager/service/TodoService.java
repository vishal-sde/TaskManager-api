package com.project.TaskManager.service;

import com.project.TaskManager.entity.Todo;
import com.project.TaskManager.repository.TodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {


    private TodoRepository todorepo;

    public TodoService(TodoRepository todorepo){
        this.todorepo = todorepo;
    }

    public Todo addTodo(Todo todo){
        return todorepo.save(todo);
    }


    public Todo getTodoById(Integer id){
        return todorepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo Not found with id"  +id));
    }

    public List<Todo> getTodoByStatus(Todo.Status status){
        return todorepo.findByStatus(status);
    }

    public Todo updateTodo(Integer id,Todo todoData){
        Todo todo = todorepo.findById(id)
                .orElseThrow(()->new RuntimeException("Todo not found with id" + id));

        todo.setTitle(todoData.getTitle());
        todo.setDescription(todoData.getDescription());
        todo.setStatus(todoData.getStatus());
        todo.setDueDate(todoData.getDueDate());
        return todorepo.save(todo);

    }

    public void deleteTodo(Integer id){
        todorepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo Not found with id"  +id));
        todorepo.deleteById(id);
    }

    public Page<Todo> getAllTodos(Pageable pageable){
        return todorepo.findAll(pageable);
    }
}
