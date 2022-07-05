package services;

import entities.Task;
import entities.ToDoList;

import java.util.Scanner;

public class TaskRemover implements IService{

    @Override
    public void showServicesInformation() {
        System.out.println("ENTER an ID of task which you want remove");
        System.out.println("OR enter 0 to exit");
    }

    @Override
    public String readUserInput() {

        while (true){
            System.out.println("Enter ID: ");
            Scanner in = new Scanner(System.in);

            try {
                String userInput = in.nextLine();
                int userInputAsNumber = Integer.parseInt(userInput);
                if (userInputAsNumber != 0) {
                    Task task = ToDoList.tasks.get(userInputAsNumber);

                    if (task != null) {
                        return userInput;
                    } else {
                        System.out.println("ID doesn't exists, try another ID: ");
                    }
                } else {
                    return userInput;
                }
            } catch (Exception e) {
                System.out.println("Invalid ID");
            }
        }
    }

    @Override
    public void executeService(String command) {
        ToDoList.tasks.remove(Integer.parseInt(command));

        System.out.println("Task with ID: " + command + ", has been successfully removed");
    }
}
