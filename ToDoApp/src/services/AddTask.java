package services;

import entities.Task;
import entities.ToDoList;

import java.util.Scanner;

public class AddTask implements IService{

    @Override
    public void showServicesInformation() {
        System.out.println("To add task define parameters as following: ");
        System.out.println("ID, TITLE, DESCRIPTION, PRIORITY(FROM 1 TO 3)\n");
        System.out.println("Enter 0 if u want EXIT adding tasks");
    }

    @Override
    public String readUserInput() {
        while(true){
            System.out.println("Enter information about task ");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            if (!"0".equals(userInput)) {
                String[] parameters = userInput.split(",");

                if(parameters.length == 4) {
                    if (!ToDoList.tasks.containsKey(Integer.parseInt(parameters[0]))) {
                        return userInput;
                    } else {
                        System.out.println("Task with this ID exists, try another id: ");
                    }
                } else {
                    System.out.println("Too much or not enough parameters, try again");
                }
            } else {
                return userInput;
            }
        }
    }

    @Override
    public void executeService(String command) {
        String[] parameters = command.split(",");
        Task task = Task.buildTask(Integer.parseInt(parameters[0]), parameters[1], parameters[2], Integer.parseInt(parameters[3]));
        ToDoList.tasks.put(task.getId(), task);
    }
}
