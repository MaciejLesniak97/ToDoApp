package services;

import entities.ToDoList;

public class TasksDisplayer implements IService{

    @Override
    public void showServicesInformation() {
        System.out.println("That's all your tasks: ");
    }

    @Override
    public String readUserInput() {
        throw new UnsupportedOperationException("it doesn't support this action");
    }

    @Override
    public void executeService(String command) {
        ToDoList.tasks.forEach((key, task) -> {
            System.out.println("ID: " + key + ", TITLE: " + task.getTitle() + ", DESCRIPTION: " + task.getDescription()
            + ", PRIORITY: " + task.getPriority() + ", STATUS: " + task.getStatus() + ", CREATED: " + task.getDateOfCreate());
        });
    }
}
