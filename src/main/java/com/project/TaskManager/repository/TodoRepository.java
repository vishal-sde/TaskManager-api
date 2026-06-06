package com.project.TaskManager.repository;

import com.project.TaskManager.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {
        List<Todo> findByStatus(Todo.Status status);

        Page<Todo> findAll(Pageable pageable);

}
