package entities;

import services.*;

import java.util.*;

public class ToDoList {

    public static Map<Integer, Task> tasks = new LinkedHashMap<>();
    public static boolean appRunning = true;

    public void start() {
        showAppName();
        while (ToDoList.appRunning) {
            showAvailableFunctions();
            int functionNumber = readFunction();
            executeFunction(functionNumber);
        }
    }

    public void executeFunction(int functionNumber) {
        IService function;

        switch (functionNumber) {
            case Functions.ADD_TASK:
                function = new AddTask();
                function.showServicesInformation();
                String command = function.readUserInput();
                if (!command.equals("0"))
                    function.executeService(command);
                break;

            case Functions.DISPLAY_ALL_TASKS:
                if (tasks.size() > 0) {
                    function = new TasksDisplayer();
                    function.showServicesInformation();
                    function.executeService(null);
                } else {
                    System.out.println("Your list is empty, add tasks first! ");
                }
                break;

            case Functions.SORT_TASKS_BY_DATE:
                function = new DateSorter();
                function.executeService(null);
                break;

            case Functions.SORT_TASKS_BY_PRIORITY:
                function = new PrioritySorter();
                function.executeService(null);
                break;

            case Functions.EDIT_TASK:
                if (tasks.size() > 0) {
                    function = new TaskEditor();
                    function.showServicesInformation();
                    String editCommand = function.readUserInput();
                    if (!editCommand.equals(0))
                        function.executeService(editCommand);
                } else {
                    System.out.println("Your list is empty, add tasks first! ");
                }
                break;

            case Functions.REMOVE_TASK:
                if (tasks.size() > 0) {
                    function = new TaskRemover();
                    function.showServicesInformation();
                    String id = function.readUserInput();
                    if (!id.equals("0"))
                        function.executeService(id);
                } else {
                    System.out.println("Your list is empty, add tasks first! ");
                }
                break;

            case Functions.MARK_AS_DONE:
                if (tasks.size() > 0) {
                    function = new Marker();
                    function.showServicesInformation();
                    String id = function.readUserInput();
                    if (!id.equals("0"))
                        function.executeService(id);

                } else {
                    System.out.println("Your List is empty, add tasks first! ");

                }
                break;

            case Functions.SAVE_TASKS_TO_FILE:
                if (tasks.size() > 0) {

                    function = new SaveToFile();
                    function.showServicesInformation();
                    String path = function.readUserInput();
                    if (!path.equals("0"))
                        function.executeService(path);
                } else {
                    System.out.println("There are no tasks to be saved!");
                }
                break;

            case Functions.READ_FROM_FILE:
                function = new FileReader();
                function.showServicesInformation();
                String path = function.readUserInput();
                if (!path.equals("0"))
                    function.executeService(path);
                break;

            case Functions.EXIT:
                appRunning = false;
                break;


        }
    }

    public void showAppName() {
        System.out.println("To-do list app");
    }

    public void showAvailableFunctions() {
        System.out.println("---------------------------");
        System.out.println("1. Add task");
        System.out.println("2. Display all tasks");
        System.out.println("3. Sort tasks by date");
        System.out.println("4. Sort tasks by priority");
        System.out.println("5. Edit task");
        System.out.println("6. Remove task");
        System.out.println("7. Mark task as done");
        System.out.println("8. Save tasks to file");
        System.out.println("9. Read tasks from file");
        System.out.println("10. Exit");
        System.out.println("---------------------------");
    }

    public int readFunction() {
        List<Integer> availableActions = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        while (true) {
            try {
                System.out.print("Enter action: ");
                Scanner scan = new Scanner(System.in);
                int action = scan.nextInt();
                if (availableActions.contains(action)) {
                    return action;
                } else {
                    System.out.println("enter a valid function from the list: ");
                }
            } catch (Exception e) {
                System.out.println("Function must be a number ");

            }
        }
    }
}


