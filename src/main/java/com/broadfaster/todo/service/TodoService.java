package com.broadfaster.todo.service;


import com.broadfaster.todo.model.Todo;
import com.broadfaster.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public ResponseEntity<Todo> addTodo(Todo todo) {

        System.out.println(todo + "from service");
        Todo addedtodo = todoRepository.save(todo);
        System.out.println(addedtodo + "Added Todo");
        return new ResponseEntity<>(addedtodo, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Todo>> getAllTodos() {
        try {
            return new ResponseEntity<>(todoRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Todo>> getTodosByCategory(String category) {
        try {
            return new ResponseEntity<>(todoRepository.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
