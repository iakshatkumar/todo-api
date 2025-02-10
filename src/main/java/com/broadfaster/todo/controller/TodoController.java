package com.broadfaster.todo.controller;

import com.broadfaster.todo.model.Todo;
import com.broadfaster.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteTodoById(@PathVariable Integer id) {
        boolean deleted = false;
        deleted = todoService.deleteTodoById(id);

//        so that we just json response
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

}
