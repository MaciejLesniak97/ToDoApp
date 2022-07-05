package services;

import entities.Task;
import entities.ToDoList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PrioritySorter implements IService{
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
            Integer priorityFirstTask = task1.getValue().getPriority();
            Integer prioritySecondTask = task2.getValue().getPriority();
            int result = priorityFirstTask.compareTo(prioritySecondTask);
            return result;
        });

        ToDoList.tasks.clear();
        entries.forEach((entry) -> {
            ToDoList.tasks.put(entry.getKey(), entry.getValue());
        });

        System.out.println("Tasks sorted by priority");
    }
}
