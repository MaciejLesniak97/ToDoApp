package services;

import entities.Task;
import entities.ToDoList;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class FileReader implements IService{
    @Override
    public void showServicesInformation() {
        System.out.println("Enter path of file which you want to read:");
        System.out.println("OR enter 0 to exit");
    }

    @Override
    public String readUserInput() {
        while (true) {
            System.out.print("path:");

            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine();

            return userInput;
        }
    }

    @Override
    public void executeService(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNextLine()) {
                String file = scanner.nextLine();
                String[] params = file.split(",");
                Task task = Task.buildTask(Integer.parseInt(params[0]), params[1], params[2],
                        Integer.parseInt(params[3]),Boolean.parseBoolean(params[4]) , LocalDate.parse(params[5]));

                if (ToDoList.tasks.get(params[0]) != null) {
                    ToDoList.tasks.replace(Integer.valueOf(params[0]), task);
                } else {
                    ToDoList.tasks.put(Integer.valueOf(params[0]), task);
                }
            }

            scanner.close();
            System.out.println("Task were read");
        } catch (FileNotFoundException e) {
            System.out.println("Invalid path or file doesn't exist");
        }
    }
}
