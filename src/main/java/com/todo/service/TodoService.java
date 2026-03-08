package com.todo.service;

import com.todo.entity.Todo;
import com.todo.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    TodoRepo todoRepository;

    public String createTodo(Todo todo) {
        todoRepository.save(todo);
        return "Task Saved";
    }

    public List<Todo> getAllList() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getById(Long id) {
        Optional<Todo> byid = todoRepository.findById(id);
        return byid;
    }

    public String deleteById(Long id) {
        todoRepository.deleteById(id);
        return "Todo Deleted";
    }
}
