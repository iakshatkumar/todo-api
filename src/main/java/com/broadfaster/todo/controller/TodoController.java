package com.broadfaster.todo.controller;

import com.broadfaster.todo.model.Todo;
import com.broadfaster.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("check")
    public String serviceStatus()  {
        return "up";
    }

    @PostMapping("add")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        System.out.println(todo + "from controller");
        return todoService.addTodo(todo);
    }

    @GetMapping("all")
    public ResponseEntity<List<Todo>> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Todo>> getTodosByCategory(@PathVariable String category) {
        return todoService.getTodosByCategory(category);
    }

}
