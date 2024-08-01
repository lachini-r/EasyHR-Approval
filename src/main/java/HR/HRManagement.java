package HR;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HRManagement {
    private List<Employee> employees;

    public HRManagement() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String position) {
        employees.add(new Employee(name, position));
        System.out.println("Employee added successfully.");
    }

    public void approveEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.approve();
                System.out.println("Employee with ID " + id + " approved.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void viewEmployees() {
        System.out.println("\nEmployees List:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public static void mainMenu() {
        int exitVariable=0;
        HRManagement hrManagement = new HRManagement();
        Scanner scanner = new Scanner(System.in);

        System.out.println("HR Management Approval Process");

        while (exitVariable==0) {
            try {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Approve Employee by ID");
            System.out.println("3. View Employees");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee position: ");
                    String position = scanner.nextLine();
                    hrManagement.addEmployee(name, position);
                    break;
                case 2:
                    System.out.print("Enter employee ID to approve: ");
                    int id = scanner.nextInt();
                    hrManagement.approveEmployeeById(id);
                    break;
                case 3:
                    hrManagement.viewEmployees();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    exitVariable=1;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();  // Clear the buffer
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }

        scanner.close();  // Close the scanner resource
    }
}