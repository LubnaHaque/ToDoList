package com.dsi.ToDoList.controllers;

import com.dsi.ToDoList.model.Task;
import com.dsi.ToDoList.repositories.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
@RequestMapping("/task/{id}")
public class TaskEditController {
    private final TaskRepository taskRepository;

    public TaskEditController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @ModelAttribute
    public Task addTaskToModel(@PathVariable Long id){
        return taskRepository.findById(id).orElseThrow(EntityNotFoundException :: new);
    }

    @GetMapping("/edit")
    public String viewEditTaskForm(@ModelAttribute Task task){
        return "/task/edit";
    }

    @PutMapping("/edit")
    public String submitEditTaskForm(@Valid @ModelAttribute Task task, BindingResult result){
        if(result.hasErrors()){
            return "/task/edit";
        }
        taskRepository.save(task);
        return "redirect:/task";
    }

    @DeleteMapping
    public String deleteTask(@ModelAttribute Task task){
        taskRepository.delete(task);
        return "redirect:/task";
    }
}
