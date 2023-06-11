package com.example.to_do_app.service.impl;

import com.example.to_do_app.model.ToDoItem;
import com.example.to_do_app.repository.ToDoItemRepository;
import org.springframework.stereotype.Service;

@Service
public class LoadSeedDataServiceImpl implements LoadSeedDataService {

    private final ToDoItemRepository toDoItemRepository;

    public LoadSeedDataServiceImpl(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }


    @Override
    public void loadSeedData() {
        if (toDoItemRepository.count() == 0) {
            ToDoItem todoItem1 = new ToDoItem("taskOne", "Integration API");
            ToDoItem todoItem2 = new ToDoItem("taskTwo", "Integration API2");

            toDoItemRepository.save(todoItem1);
            toDoItemRepository.save(todoItem2);
        }
    }
}