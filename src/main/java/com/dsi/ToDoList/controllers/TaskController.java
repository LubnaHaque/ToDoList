package com.dsi.ToDoList.controllers;

import com.dsi.ToDoList.model.Task;
import com.dsi.ToDoList.repositories.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/task")
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @ModelAttribute
    public Task addTaskToModel(@PathVariable Optional<Long> id){
        return id.map(taskRepository::getOne)
                .orElseGet(Task::new);
    }

    @GetMapping("/new")
    public String showNewTask(){
        return "task/task_new";
    }

    @PostMapping("/new")
    public String addNewTask(@Valid @ModelAttribute Task task , BindingResult result){
        if(result.hasErrors()){
            return showNewTask();
        }
        taskRepository.save(task);
        return "redirect:/task";
    }

    @GetMapping
    public ModelAndView listTasks(){
        ModelAndView modelAndView = new ModelAndView("task/task_list")
                .addObject(taskRepository.findAll());

        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public String showEditTask(@ModelAttribute Task task){
        return "task/task_edit";
    }

    @PutMapping(value = "/{id}/edit")
    public String submitEditTask(@ModelAttribute Task task, BindingResult result){
        if(result.hasErrors()){
            showEditTask(task);
        }
        taskRepository.save(task);

        return "redirect:/task";
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@ModelAttribute Task task){
        taskRepository.delete(task);
        return "redirect:/task";
    }
}

