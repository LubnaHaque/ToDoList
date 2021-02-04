package com.dsi.ToDoList.controllers;

import com.dsi.ToDoList.model.Task;
import com.dsi.ToDoList.repositories.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskListController {
    private final TaskRepository taskRepository;

    public TaskListController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @ModelAttribute
    public List<Task> addTaskListToModel(){
        return taskRepository.findAll();
    }

    @GetMapping
    public String list(){
        return "/task/list";
    }

}
