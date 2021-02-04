package com.dsi.ToDoList.controllers;

import com.dsi.ToDoList.model.Task;
import com.dsi.ToDoList.repositories.TaskRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskRestController {
    public final TaskRepository taskRepository;

    public TaskRestController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/index")
    public String runIndex(){
        System.out.println(taskRepository.findAll().size());
        return "index";
    }
    
    @GetMapping("/task")
    public List<Task> getTask(){
        return taskRepository.findAll();
    }
}
