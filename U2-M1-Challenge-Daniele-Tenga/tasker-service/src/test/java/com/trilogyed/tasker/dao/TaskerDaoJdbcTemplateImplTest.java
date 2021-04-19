package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoJdbcTemplateImplTest {

    @Autowired
    TaskerDao taskerDao;

    private Task task;

    @Before
    public void setUp() throws Exception {
        clearDatabase();
        setUpTestObjects();
    }
    public void clearDatabase() {
        List<Task> console = taskerDao.getAllTasks();
        for (Task it : console) {
            taskerDao.deleteTask(it.getId());
        }

    }

    public void setUpTestObjects() {
        task = new Task();

        task.setCategory("kitchen");
        task.setTaskDescription("cooking");
        task.setDueDate(LocalDate.of(2003,05,10));
        task.setCreateDate(LocalDate.of(2003,03,15));

        task = taskerDao.createTask(task);

    }

    //    public Task createTask(Task task);
    @Test
    public void shouldAddAndGetTask() {
        task = taskerDao.createTask(task);

        Task task2 = taskerDao.getTask(task.getId());
        assertEquals(task2,task);
    }

    //    public void deleteTask(int id);
    @Test
    public void shouldDeleteTask() {

        Task task2 = new Task();

        task2.setCategory("kitchen");
        task2.setTaskDescription("cooking");
        task2.setDueDate(LocalDate.of(2003,05,10));
        task2.setCreateDate(LocalDate.of(2003,03,15));
        task2 = taskerDao.createTask(task);

        taskerDao.deleteTask(task2.getId());
        Task task3 = taskerDao.getTask(task2.getId());
        assertNull(task3);
    }


    @Test
    public void shouldUpdateTask() {

        Task task = new Task();

        task.setCategory("kitchen");
        task.setTaskDescription("cooking");
        task.setDueDate(LocalDate.of(2003,05,10));
        task.setCreateDate(LocalDate.of(2003,03,15));
        task = taskerDao.createTask(task);

        task.setCategory("Bubble");
        task.setTaskDescription("pink");
        taskerDao.updateTask(task);

        Task task2 = taskerDao.getTask(task.getId());
        assertEquals(task2,task);
    }

    @Test
    public void shouldGetAllTasks() {

        task = new Task();

        task.setCategory("kitchen");
        task.setTaskDescription("cooking");
        task.setDueDate(LocalDate.of(2003,05,10));
        task.setCreateDate(LocalDate.of(2003,03,15));
        task = taskerDao.createTask(task);

        Task task2 = new Task();

        task2.setCategory("kitchen");
        task2.setTaskDescription("cooking");
        task2.setDueDate(LocalDate.of(2003,05,10));
        task2.setCreateDate(LocalDate.of(2003,03,15));
        task2 = taskerDao.createTask(task);


        List<Task> tList = taskerDao.getAllTasks();
        assertEquals(3, tList.size());
    }

//    Find tasks by category

    @Test
    public void shouldFindTaskByCategory() {

        Task task2 = new Task();

        task2.setCategory("braisen");
        task2.setTaskDescription("cooking");
        task2.setDueDate(LocalDate.of(2003,05,10));
        task2.setCreateDate(LocalDate.of(2003,03,15));
        task2 = taskerDao.createTask(task2);

        List<Task> tList = taskerDao.getTasksByCategory("braisen");
        assertEquals(1,tList.size());
    }

//    Find task by ID:

}