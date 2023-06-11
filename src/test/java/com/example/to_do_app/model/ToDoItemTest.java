package com.example.to_do_app.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ToDoItemTest {

    @Test
    void setIdTest() {
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setId(1L);
        Assertions.assertEquals(1L, toDoItem.getId());
    }

    @Test
    void setTitleTest() {
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setTitle("api");
        Assertions.assertEquals("api", toDoItem.getTitle());
    }

    @Test
    void setDescriptionTest() {
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setDescription("integration API");
        Assertions.assertEquals("integration API", toDoItem.getDescription());
    }

}
