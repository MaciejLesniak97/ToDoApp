package services;

import entities.Task;
import entities.ToDoList;

import java.time.LocalDate;
import java.util.*;

public class DateSorter implements IService{
    @Override
    public void showServicesInformation() {
        throw new UnsupportedOperationException("it doesn't support this action");
    }

    @Override
    public String readUserInput() {
        throw new UnsupportedOperationException("it doesn't support this action");
    }

    @Override
    public void executeService(String command) {
        List<Map.Entry<Integer, Task>> entries = new ArrayList<>(ToDoList.tasks.entrySet());
        Collections.sort(entries, (task1, task2) -> {
            LocalDate dateOfCreateFirstTask = task1.getValue().getDateOfCreate();
            LocalDate dateOfCreateSecondTask = task2.getValue().getDateOfCreate();
            int result = dateOfCreateFirstTask.compareTo(dateOfCreateSecondTask);
            return result;
        });

        ToDoList.tasks.clear();
        entries.forEach((entry) -> {
            ToDoList.tasks.put(entry.getKey(), entry.getValue());
        });

        System.out.println("Tasks sorted by date");
    }
}
