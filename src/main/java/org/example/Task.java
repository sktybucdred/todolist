package org.example;

import java.time.LocalDate;

public class Task {
    private String description;
    private TaskStatus status;
    private LocalDate duedate;
    private TaskPriority priority;
    public enum TaskStatus {
        PENDING, COMPLETED, IN_PROGRESS
    }

    public enum TaskPriority {
        HIGH, MEDIUM, LOW
    }
    public Task(String description, TaskStatus status, LocalDate duedate, TaskPriority priority)
    {
        this.description = description;
        this.status = status;
        this.duedate = duedate;
        this.priority = priority;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    public void setStatus(TaskStatus status)
    {
        this.status = status;
    }
    public void setDueDate(LocalDate duedate)
    {
        this.duedate = duedate;
    }
    public void setPriority(TaskPriority priority)
    {
        this.priority = priority;
    }
    public String getDescription(){
        return description;
    }
    public LocalDate getDueDate(){
        return duedate;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public TaskStatus getStatus() {
        return status;
    }
}
