package com.todo.controller;

import com.todo.entity.Todo;
import com.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    // Create Task
    @PostMapping("/createTodo")
    public ResponseEntity<String> createTodo(@RequestBody Todo todo) {
        String msg = todoService.createTodo(todo);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    //get all tasks
    @GetMapping("/getAllList")
    public  ResponseEntity<List<Todo>> getAllTodoList(){
        List<Todo> todolist = todoService.getAllList();
        return new ResponseEntity<>(todolist,HttpStatus.OK);
    }

    //get by id
    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Todo>> getById(@PathVariable("id") long id){
        Optional<Todo> todoById = todoService.getById(id);
        return new ResponseEntity<>(todoById,HttpStatus.OK);
    }

    //delete by id
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") long id){
        String msg = todoService.deleteById(id);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
}
