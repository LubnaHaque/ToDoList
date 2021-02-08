package com.dsi.ToDoList.rest;

import com.dsi.ToDoList.api.ApiResponseModel;
import com.dsi.ToDoList.api.ResponseStatus;
import com.dsi.ToDoList.model.Task;
import com.dsi.ToDoList.repositories.TaskRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskRestController {
    public final TaskRepository taskRepository;

    public TaskRestController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public ApiResponseModel getTaskList(){
        ApiResponseModel response = new ApiResponseModel();
        response.setPayload(new HashMap<String, Object>());

        List<Task> tasks = taskRepository.findAll();
        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.getPayload().put("tasks", tasks);

        return response;
    }

}
