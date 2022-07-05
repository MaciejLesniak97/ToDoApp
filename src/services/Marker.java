package services;

import entities.Task;
import entities.ToDoList;

import java.util.Scanner;

public class Marker implements IService{

    @Override
    public void showServicesInformation() {
        System.out.println("Enter ID of task which you want mark as done: ");
        System.out.println("OR enter 0 to exit");
    }

    @Override
    public String readUserInput() {
        while (true) {
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
        ToDoList.tasks.get(Integer.parseInt(command)).setDone(true);
        System.out.println("Status has been changed for task of ID: " + command);
    }
}
