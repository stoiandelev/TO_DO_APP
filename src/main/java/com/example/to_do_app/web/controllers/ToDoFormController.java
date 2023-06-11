package com.example.to_do_app.web.controllers;

import com.example.to_do_app.model.ToDoItem;
import com.example.to_do_app.repository.ToDoItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ToDoFormController {

    private final ToDoItemRepository toDoItemRepository;

    public ToDoFormController(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    @GetMapping("/create-todo")
    public String showCreateForm(ToDoItem todoItem){
        return "add-todo-item";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        ToDoItem todoItem = toDoItemRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        model.addAttribute("todo", todoItem);
        return "update-todo-item";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") long id, Model model) {
        ToDoItem todoItem = toDoItemRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        toDoItemRepository.delete(todoItem);
        return "redirect:/";
    }

}
