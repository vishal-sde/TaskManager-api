package com.project.TaskManager.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
@Data
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 200)
    @NotBlank
    @Size(min = 1,max = 200,message = "Title should be between 1 to 200 characters")
    private String title;

    @Column
    private String description;

    public enum Status{
        PENDING,
        COMPLETED
    }

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    private LocalDate dueDate;


}
