package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.exception.NotFoundException;
import com.trilogyed.tasker.feign.Adserver;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class TaskerController {

    @Autowired
    TaskerServiceLayer service;


    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

//    Create a new task:
//            ------------------
//    URI: /tasks
//    HTTP Method: POST
//    RequestBody: JSON TaskViewModel information (minus advertisement)
//    ResponseBody: JSON TaskViewModel information (including ID and advertisement)

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public TaskViewModel createTask(@Valid @RequestBody TaskViewModel information /*minus advertisement*/){
        return service.newTask(information) /*with id and advertisement*/;
    }

//    Update a task:
//            --------------
//    URI: /tasks
//    HTTP Method: PUT
//    RequestBody: JSON TaskViewModel information (including ID and advertisement)
//    ResponseBody: None

    @RequestMapping(value = "/tasks", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTask(@Valid @RequestBody TaskViewModel taskViewModel /*minus advertisement*/){
        service.updateTask(taskViewModel); /*none*/;
    }

//    Find task by ID:
//----------------
//URI: /tasks/{id}
//HTTP Method: GET
//RequestBody: None
//ResponseBody: JSON TaskViewModel information (including ID and advertisement)

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TaskViewModel findTaskById(@PathVariable int id /*none*/){
         /*with id and advertisement*/;
        TaskViewModel taskViewModel = service.fetchTask(id);
        if (taskViewModel == null)
            throw new NotFoundException("Console could not be retrieved for id " + id);
        return taskViewModel;
    }

//    Find all tasks:
//---------------
//URI: /tasks
//HTTP Method: GET
//RequestBody: None
//ResponseBody: JSON List of TaskViewModels (including ID and advertisement)

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public  List<TaskViewModel> findAllTasks(){
        return service.fetchAllTasks(); /*with id and advertisement*/
    }

//    Delete task:
//            ------------
//    URI: /tasks/{id}
//    HTTP Method: DELETE
//    RequestBody: None
//    Responsebody: None

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }

//    find task by category
    @GetMapping("/tasks/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> findTaskByCategory(@PathVariable("category") String category) {
        List<TaskViewModel> tasks = service.fetchTasksByCategory(category);
        if (tasks != null && tasks.size() == 0)
            throw new NotFoundException("Invoice could not be retrieved for customer " + category);
        return tasks;
    }
}
