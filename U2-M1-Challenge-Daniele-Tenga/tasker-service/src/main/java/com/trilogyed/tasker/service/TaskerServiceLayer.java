package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.feign.Adserver;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    private TaskerDao dao;
    Adserver adserver;

    @Autowired
    public TaskerServiceLayer(TaskerDao dao, Adserver adserver ) {
        this.adserver = adserver;
        this.dao = dao;
    }


    @Transactional
    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setTaskDescription(task.getTaskDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());
        // TODO - get ad from Adserver and put in tvm
        String ad = adserver.getAd();
        tvm.setAdvertisement(ad);

        return tvm;
    }

    @Transactional
    public List<TaskViewModel> fetchAllTasks() {

        List<Task> taskList = dao.getAllTasks();
        List<TaskViewModel> taskViewModelList = new ArrayList<>();

        for (Task task : taskList) {
            TaskViewModel tvm = buildTaskViewModel(task);
            taskViewModelList.add(tvm);
        }
        return  taskViewModelList;

    }

    @Transactional
    public List<TaskViewModel> fetchTasksByCategory(String category) {

        List<Task> taskList = dao.getTasksByCategory(category);
        List<TaskViewModel> taskViewModelList = new ArrayList<>();

        for (Task task: taskList) {
            taskViewModelList.add(buildTaskViewModel(task));
        }
        return taskViewModelList;

    }

    @Transactional
    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setTaskDescription(taskViewModel.getTaskDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());
        task = dao.createTask(task);
        taskViewModel.setId(task.getId());
//        task.setId(taskViewModel.getId());//////////////************

        taskViewModel.setAdvertisement(adserver.getAd());
        // TODO - get ad from Adserver and put in taskViewModel
//        String ad = adserver.getAd();
//        taskViewModel.setAdvertisement(ad);

        return taskViewModel;
    }

    @Transactional
    public void deleteTask(int id) {
        dao.deleteTask(id);

    }

    @Transactional
    public void updateTask(TaskViewModel taskViewModel) {

            Task task = new Task();
            task.setId(taskViewModel.getId());
            task.setTaskDescription(taskViewModel.getTaskDescription());
            task.setCreateDate(taskViewModel.getCreateDate());
            task.setCategory(taskViewModel.getCategory());
            task.setDueDate(taskViewModel.getDueDate());

            dao.updateTask(task);
    }

    private TaskViewModel buildTaskViewModel(Task task) {


        TaskViewModel taskViewModel = new TaskViewModel();

        taskViewModel.setId(task.getId());
        taskViewModel.setAdvertisement(adserver.getAd());
        taskViewModel.setCategory(task.getCategory());
        taskViewModel.setCreateDate(task.getCreateDate());
        taskViewModel.setDueDate(task.getDueDate());
        taskViewModel.setTaskDescription(task.getTaskDescription());

        return taskViewModel;
    }


}
