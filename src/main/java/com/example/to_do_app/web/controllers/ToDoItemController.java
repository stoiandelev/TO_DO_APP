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
public class ToDoItemController {

    private final ToDoItemRepository toDoItemRepository;

    public ToDoItemController(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }


    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("toDoItems", toDoItemRepository.findAll());

        return modelAndView;
    }


    @PostMapping("/todo")
    public String createTodoItem(@Valid ToDoItem todoItem, BindingResult result) {
        if (result.hasErrors()) {
            return "add-todo-item";
        }

        toDoItemRepository.save(todoItem);
        return "redirect:/";
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

}
