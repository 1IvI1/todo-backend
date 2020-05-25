package com.todo.database.repositories;

import org.springframework.data.repository.CrudRepository;
import com.todo.database.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository extends CrudRepository<ToDo, Integer> {
    List<ToDo> findAll();
    Optional<ToDo> findById(Integer id);

    @Override
    ToDo save(ToDo s);
}
