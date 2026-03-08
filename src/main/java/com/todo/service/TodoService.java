package com.todo.service;

import com.todo.entity.Todo;
import com.todo.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    TodoRepo todoRepository;

    public String createTodo(Todo todo) {
        todoRepository.save(todo);
        return "Task Saved";
    }
}
