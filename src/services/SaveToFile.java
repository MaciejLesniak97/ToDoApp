package services;

import entities.ToDoList;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SaveToFile implements IService{
    @Override
    public void showServicesInformation() {
        System.out.println("Enter a path to file: ");
        System.out.println("OR enter 0 to exit");
    }

    @Override
    public String readUserInput() {
        while (true) {
            System.out.println("path: ");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            return userInput;
        }
    }

    @Override
    public void executeService(String path) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));

            List<String> lines = ToDoList.tasks.entrySet()
                    .stream()
                    .map(entry -> entry.getValue().toString())
                    .collect(Collectors.toList());

            lines.forEach((line) -> {
                try {
                    bufferedWriter.write(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            bufferedWriter.close();
            System.out.println("Tasks saved into file: " + path);
        } catch (FileNotFoundException e) {
            System.out.println("Path or file doesn't exist");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
