package com.example.to_do_app.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "todo_task")
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @NotBlank(message = "Title is required")
    @Column
    private String title;

    @NotBlank(message = "Description is required")
    @Column
    private String description;


    public ToDoItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public ToDoItem() {
    }

    public Long getId() {
        return id;
    }

    public ToDoItem setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ToDoItem setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ToDoItem setDescription(String description) {
        this.description = description;
        return this;
    }
}
