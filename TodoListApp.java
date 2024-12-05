import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    viewTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("To-Do List Application");
        System.out.println("1. Add Task");
        System.out.println("2. Edit Task");
        System.out.println("3. Remove Task");
        System.out.println("4. View Tasks");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addTask() {
        System.out.print("Enter the task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    private static void editTask() {
        viewTasks();
        System.out.print("Enter the task number to edit: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            System.out.print("Enter the new task: ");
            String newTask = scanner.nextLine();
            tasks.set(taskNumber - 1, newTask);
            System.out.println("Task edited successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void removeTask() {
        viewTasks();
        System.out.print("Enter the task number to remove: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    @Override
    public String toString() {
        return "TodoListApp []";
    }
}
