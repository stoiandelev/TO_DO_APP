package com.example.to_do_app.config;

import com.example.to_do_app.service.LoadSeedDataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ToDoItemDataLoader implements CommandLineRunner {

    private final LoadSeedDataService loadSeedDataService;

    public ToDoItemDataLoader(LoadSeedDataService loadSeedDataService) {
        this.loadSeedDataService = loadSeedDataService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadSeedDataService.loadSeedData();
    }
}
