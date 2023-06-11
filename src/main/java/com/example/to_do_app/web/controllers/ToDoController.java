package com.example.to_do_app.web.controllers;

import com.example.to_do_app.model.ToDoItem;
import com.example.to_do_app.repository.ToDoItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ToDoController {

    private final ToDoItemRepository toDoItemRepository;

    public ToDoController(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }


    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", toDoItemRepository.findAll());

        return modelAndView;
    }

    @GetMapping("/create-todo")
    public String showCreateForm(ToDoItem todoItem) {
        return "add-todo-item";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid ToDoItem todoItem, BindingResult result) {
        if (result.hasErrors()) {
            return "add-todo-item";
        }

        toDoItemRepository.save(todoItem);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        ToDoItem todoItem = toDoItemRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        model.addAttribute("todo", todoItem);
        return "update-todo-item";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") long id, @Valid ToDoItem todoItem,
                                 BindingResult result) {
        if (result.hasErrors()) {
            todoItem.setId(id);
            return "update-todo-item";
        }

        toDoItemRepository.save(todoItem);
        return "redirect:/";
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
