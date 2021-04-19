package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.feign.Adserver;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskerServiceLayerTest {

    TaskerDao taskerDao;
    TaskerServiceLayer taskerServiceLayer;
    Adserver adserver;

    @Before
    public void setUp() throws Exception {

        setUpTaskDaoMock();
        setUpAdServerMock();

        taskerServiceLayer = new TaskerServiceLayer(taskerDao, adserver);
    }


    private void setUpTaskDaoMock() {

        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);

        Task task = new Task();

        task.setCategory("kitchen");
        task.setTaskDescription("cooking");
        task.setDueDate(LocalDate.of(2003,05,10));
        task.setCreateDate(LocalDate.of(2003,03,15));

        Task task2 = new Task();

        task2.setCategory("kitchen2");
        task2.setTaskDescription("cooking");
        task2.setDueDate(LocalDate.of(2003,05,10));
        task2.setCreateDate(LocalDate.of(2003,03,15));

        Task outputtask = new Task();

        outputtask.setId(1);
        outputtask.setCategory("kitchen");
        outputtask.setTaskDescription("cooking");
        outputtask.setDueDate(LocalDate.of(2003,05,10));
        outputtask.setCreateDate(LocalDate.of(2003,03,15));

        Task outputtask2 = new Task();

        outputtask2.setId(2);
        outputtask2.setCategory("kitchen2");
        outputtask2.setTaskDescription("cooking");
        outputtask2.setDueDate(LocalDate.of(2003,05,10));
        outputtask2.setCreateDate(LocalDate.of(2003,03,15));

        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        taskList.add(task2);
        List<Task> category = new ArrayList<>();
        category.add(task2);
        List<Task> category2 = new ArrayList<>();
        category2.add(task);

        doReturn(outputtask).when(taskerDao).createTask(task);
        doReturn(outputtask2).when(taskerDao).createTask(task2);
        doReturn(outputtask).when(taskerDao).getTask(1);
        doReturn(outputtask).when(taskerDao).getTask(2);
        doReturn(taskList).when(taskerDao).getAllTasks();
        doReturn(category).when(taskerDao).getTasksByCategory("kitchen");
        doReturn(category).when(taskerDao).getTasksByCategory("kitchen2");
    }

    private void setUpAdServerMock(){
        adserver =mock(Adserver.class);
        when(adserver.getAd()).thenReturn("AD");
    }

    @Test
    public void shouldFetchTask() {
        Task task = new Task();

        task.setDueDate(LocalDate.of(2003,05,10));
        task.setCategory("kitchen");
        task.setTaskDescription("cooking");
        task.setCreateDate(LocalDate.of(2020,05,05));

        TaskViewModel outputtask = new TaskViewModel();

        outputtask.setId(1);
        outputtask.setCategory("kitchen");
        outputtask.setTaskDescription("cooking");
        outputtask.setAdvertisement("AD");
        outputtask.setDueDate(LocalDate.of(2003,05,10));
        outputtask.setCreateDate(LocalDate.of(2003,03,15));


        TaskViewModel task2 = taskerServiceLayer.fetchTask(outputtask.getId());
        Assert.assertEquals(outputtask,task2);
    }


    @Test
    public void shouldFetchAllTasks() {

        Task task = new Task();

        task.setCategory("kitchen");
        task.setTaskDescription("cooking");
        task.setDueDate(LocalDate.of(2003,05,10));
        task.setCreateDate(LocalDate.of(2003,03,15));

        Task task2 = new Task();

        task2.setCategory("kitchen2");
        task2.setTaskDescription("cooking");
        task2.setDueDate(LocalDate.of(2003,05,10));
        task2.setCreateDate(LocalDate.of(2003,03,15));

        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        taskList.add(task2);
        assertEquals(2, taskList.size());
    }

    @Test
    public void shouldFetchTasksByCategory(){

        Task task2 = new Task();

        task2.setCategory("kitchen2");
        task2.setTaskDescription("cooking");
        task2.setDueDate(LocalDate.of(2003,05,10));
        task2.setCreateDate(LocalDate.of(2003,03,15));

        List<Task> category = new ArrayList<>();
        category.add(task2);
        assertEquals(1, category.size());
    }

    @Test
    public void shouldCreateNewTask(){

        TaskViewModel task = new TaskViewModel();

        task.setCategory("kitchen");
        task.setTaskDescription("cooking");
        task.setDueDate(LocalDate.of(2003,05,10));
        task.setCreateDate(LocalDate.of(2003,03,15));

        TaskViewModel taskViewModel2 = new TaskViewModel();

        taskViewModel2.setDueDate(LocalDate.of(2003,05,10));
        taskViewModel2.setAdvertisement("AD");
        taskViewModel2.setCategory("kitchen");
        taskViewModel2.setTaskDescription("cooking");
        taskViewModel2.setCreateDate(LocalDate.of(2003,03,15));

        task = taskerServiceLayer.newTask(task);
        assertNotNull(task);
    }

}