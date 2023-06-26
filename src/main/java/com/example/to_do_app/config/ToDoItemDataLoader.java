package com.example.to_do_app.config;

import com.example.to_do_app.service.LoadSeedDataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * We can use -> to fill the database
 *  @PostConstruct
 *     private void postConstruct() {
 *         User admin = new User("admin", "admin password");
 *         User normalUser = new User("user", "user password");
 *         userRepository.save(admin, normalUser);
 *     }
 */

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
