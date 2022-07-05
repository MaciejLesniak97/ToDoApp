package entities;

import java.time.LocalDate;

public class Task {
    private int id;
    private String title;
    private String description;
    private int priority;
    private boolean isDone;
    private LocalDate dateOfCreate;

    public static Task buildTask(int id, String title, String description, int priority) {
        Task task = new Task();

        task.setId(id);
        task.setTitle(title);
        task.setDescription(description);
        task.setPriority(priority);
        task.setDone(false);
        task.setDateOfCreate();

        return task;
    }

    public static Task buildTask(int id, String title, String description, int priority, boolean isDone, LocalDate dateOfCreate){
        Task task = new Task();

        task.setId(id);
        task.setTitle(title);
        task.setDescription(description);
        task.setPriority(priority);
        task.setDone(isDone);
        task.setDateOfCreate(dateOfCreate);

        return task;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public boolean getStatus() {
        return isDone;
    }

    public LocalDate getDateOfCreate() {
        return dateOfCreate;
    }

    public void setId(int id) {
        this.id = id;
    };

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        if (priority > 0 && priority < 4)
            this.priority = priority;
        else throw new IllegalArgumentException("priority must be from 1-3");
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void setDateOfCreate() {
        this.dateOfCreate = LocalDate.now();
    }

    public void setDateOfCreate(LocalDate dateOfCreate){
        this.dateOfCreate = dateOfCreate;
    }
}
