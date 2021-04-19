package com.trilogyed.tasker.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

public class Task {

    private int id;
    @NotBlank @Size(max = 255, message = "cannot exceed 255 characters")
    private String taskDescription;
    @NotNull
    private LocalDate createDate;
    @NotNull
    private LocalDate dueDate;
    @NotBlank @Size(max = 50, message = "cannot exceed 50 characters")
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(taskDescription, task.taskDescription) && Objects.equals(createDate, task.createDate) && Objects.equals(dueDate, task.dueDate) && Objects.equals(category, task.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskDescription, createDate, dueDate, category);
    }
}
