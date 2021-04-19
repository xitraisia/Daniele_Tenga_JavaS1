package com.trilogyed.tasker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.tasker.feign.Adserver;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskerController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class TaskerControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private TaskerServiceLayer taskerServiceLayer;

    private ObjectMapper mapper = new ObjectMapper();


    @Before
    public void setUp() {

    }

    public void clearDatabase() {
        List<TaskViewModel> task = taskerServiceLayer.fetchAllTasks();
        for (TaskViewModel it : task) {
            taskerServiceLayer.deleteTask(it.getId());
        }
    }

    //    Find task by ID:

    @Test
    public void findTaskById() throws Exception {

        TaskViewModel inputtask = new TaskViewModel();

        inputtask.setCreateDate(LocalDate.of(2003,03,15));
        inputtask.setDueDate(LocalDate.of(2003,05,10));
        inputtask.setTaskDescription("cooking");
        inputtask.setCategory("kitchen");
        inputtask.setId(2);


        String outputJson = mapper.writeValueAsString(inputtask);

        when(taskerServiceLayer.fetchTask(2)).thenReturn(inputtask);

        this.mockMvc.perform(get("/tasks/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }


    //    Create a new task:
    @Test
    public void createNewTask() throws Exception {

        TaskViewModel inputtask = new TaskViewModel();

        inputtask.setCreateDate(LocalDate.of(2003,03,15));
        inputtask.setDueDate(LocalDate.of(2003,05,10));
        inputtask.setTaskDescription("cooking");
        inputtask.setCategory("kitchen");

        //Object to JSON in String
        String inputJson = mapper.writeValueAsString(inputtask);

        TaskViewModel outputtask = new TaskViewModel();

        outputtask.setCreateDate(LocalDate.of(2003,03,15));
        outputtask.setDueDate(LocalDate.of(2003,05,10));
        outputtask.setTaskDescription("cooking");
        outputtask.setCategory("kitchen");

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(outputtask);

        when(taskerServiceLayer.newTask(inputtask)).thenReturn(outputtask);

        this.mockMvc.perform(post("/tasks")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    //    public List<Task> getTasksByCategory(String category);
    @Test
    public void findTasksByCategory() throws Exception {

        TaskViewModel inputtask = new TaskViewModel();

        inputtask.setCreateDate(LocalDate.of(2003,03,15));
        inputtask.setDueDate(LocalDate.of(2003,05,10));
        inputtask.setTaskDescription("cooking");
        inputtask.setCategory("kitchen");

        TaskViewModel outputtask = new TaskViewModel();

        outputtask.setCreateDate(LocalDate.of(2003,03,15));
        outputtask.setDueDate(LocalDate.of(2003,05,10));
        outputtask.setTaskDescription("cooking");
        outputtask.setCategory("kitchen");


        List<TaskViewModel> taskViewModelList = new ArrayList<>();
        taskViewModelList.add(inputtask);
        taskViewModelList.add(outputtask);

        String outputJson = mapper.writeValueAsString(taskViewModelList);

        when(taskerServiceLayer.fetchTasksByCategory(inputtask.getCategory())).thenReturn(taskViewModelList);

        this.mockMvc.perform(get("/tasks/category/" + inputtask.getCategory()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    //    Update a task:
    @Test
    public void updateTaskShouldReturnAnUpdatedTask() throws Exception {

        TaskViewModel inputtask = new TaskViewModel();

        inputtask.setCreateDate(LocalDate.of(2003,03,15));
        inputtask.setDueDate(LocalDate.of(2003,05,10));
        inputtask.setTaskDescription("cooking");
        inputtask.setCategory("kitchen");
        inputtask.setId(4);
//        taskerServiceLayer.newTask(inputtask);
//
//        inputtask.setTaskDescription("cleaning");
//        inputtask.setCategory("Housing");
//
//        taskerServiceLayer.updateTask(inputtask);

        //these will be the same
        String inputJson = mapper.writeValueAsString(inputtask);
        String outputJson = mapper.writeValueAsString(inputtask);

        this.mockMvc.perform(put("/tasks" )
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNoContent());
    }

    //findall tasks

    @Test
    public void findAllTasks() throws Exception{

        TaskViewModel inputtask = new TaskViewModel();

        inputtask.setCreateDate(LocalDate.of(2003,03,15));
        inputtask.setDueDate(LocalDate.of(2003,05,10));
        inputtask.setTaskDescription("cooking");
        inputtask.setCategory("kitchen");

        TaskViewModel outputtask = new TaskViewModel();

        outputtask.setCreateDate(LocalDate.of(2003,03,15));
        outputtask.setDueDate(LocalDate.of(2003,05,10));
        outputtask.setTaskDescription("cooking");
        outputtask.setCategory("kitchen");


        List<TaskViewModel> taskViewModelList = new ArrayList<>();
        taskViewModelList.add(inputtask);
        taskViewModelList.add(outputtask);

        when(taskerServiceLayer.fetchAllTasks()).thenReturn(taskViewModelList);
        assertEquals(2, taskViewModelList.size());
    }

    //    Delete task:

    @Test
    public void deleteConsoleIsOkNoContentReturned() throws Exception {

        //can't mock the call to delete. it returns void
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/tasks/2"))
                .andDo(print()).andExpect(status().isNoContent())
                .andExpect(content().string(""));
    }
}