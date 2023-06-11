package com.example.to_do_app.web.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class ToDoFormControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testShowCreateForm() throws Exception {
        mockMvc.perform(get("/create-todo"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-todo-item"));
    }





}
