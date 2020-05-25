package com.todo.controllers;

import com.todo.database.ToDo;
import com.todo.database.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/todo")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class ToDoController {

    @Autowired
    ToDoRepository toDoRepository;

    @GetMapping("/get")
    public @ResponseBody
    List<ToDo> getToDos() {
        return toDoRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody List<ToDo> deleteTodoById(@PathVariable Integer id) {
        toDoRepository.deleteById(id);
        return getToDos();
    }

    @PutMapping("/update/{id}")
    public @ResponseBody List<ToDo> updateToDoById(@PathVariable Integer id, @RequestBody ToDo toDo) {
        List<ToDo> toDos = toDoRepository.findAll();
        for (int i = 0; i < toDos.size(); i++) {
            if(toDos.get(i).id.equals(toDo.id)) {
                toDos.set(i,toDo);
            }
        }
        toDoRepository.saveAll(toDos);
        return toDoRepository.findAll();
    }

    @PostMapping("/create")
    public @ResponseBody List<ToDo> createTodo(@RequestBody ToDo toDo) {
        toDo.status = "pending";
        toDoRepository.save(toDo);
        return toDoRepository.findAll();
    }
}
