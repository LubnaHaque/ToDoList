package com.dsi.ToDoList.controllers;

import com.dsi.ToDoList.model.Task;
import com.dsi.ToDoList.repositories.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/task")
public class TaskNewController {
    private final TaskRepository taskRepository;

    public TaskNewController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @ModelAttribute
    public Object addTaskToModel(){
        return new Task();
    }

    @GetMapping("/new")
    public String viewNewTaskForm(){
        return "/task/new";
    }

    @PostMapping("/new")
    public String submitNewTaskForm(@Valid Task task, BindingResult result){
        if(result.hasErrors()){
            return "/task/new";
        }
        taskRepository.save(task);
        return "redirect:/task";
    }
}
