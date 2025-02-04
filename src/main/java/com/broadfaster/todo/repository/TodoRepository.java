package com.broadfaster.todo.repository;

import com.broadfaster.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    List<Todo> findByCategory(String category);
}
