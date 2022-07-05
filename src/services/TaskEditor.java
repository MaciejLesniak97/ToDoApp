package services;

import entities.ToDoList;

import java.util.Scanner;

public class TaskEditor implements IService{

    @Override
    public void showServicesInformation() {
        System.out.println("to update a task, follow the instructions and press ENTER: ");
        System.out.println("ID, Title, Description, Priority, Status");
        System.out.println("ID here represent the ID of the task that u want update");
        System.out.println("don't insert anything when an update is not needed to that specific parameter\n");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readUserInput() {
        while (true) {
            System.out.println("Enter information");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            if(!userInput.equals(0)) {
                String[] params = userInput.split(",");

                if(params.length == 5){
                    if (ToDoList.tasks.containsKey(params[0])) {
                        return userInput;
                    } else {
                        System.out.println("Task of this id doesn't exist");
                    }
                } else {
                    System.out.println("Follow the instruction or enter 0 to end operation");
                }
            } else {
                return userInput;
            }
        }
    }

    @Override
    public void executeService(String command) {

        String[] params = command.split(",");

        if(!"".equals(params[1])) {
            ToDoList.tasks.get(params[0]).setTitle(params[1]);
            System.out.println("Title changed successfully");
        }
        if(!"".equals(params[2])) {
            ToDoList.tasks.get(params[0]).setDescription(params[2]);
            System.out.println("Description changed successfully");
        }
        if(!"".equals(params[3])) {
            ToDoList.tasks.get(params[0]).setPriority(Integer.parseInt(params[3]));
            System.out.println("Priority changed successfully");
        }
        if(!"".equals(params[4])) {
            ToDoList.tasks.get(params[0]).setDone(Boolean.parseBoolean(params[4]));
            System.out.println("Status changed successfully");
        }
    }
}
