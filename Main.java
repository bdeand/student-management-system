import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();

            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid option! Please enter a number.");
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("Student ID: ");
                    String id = scanner.nextLine().trim();

                    System.out.print("Name: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Age: ");
                    int age;

                    try {
                        age = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age!");
                        break;
                    }

                    System.out.print("Department: ");
                    String department = scanner.nextLine().trim();

                    System.out.print("GPA: ");
                    double gpa;

                    try {
                        gpa = Double.parseDouble(scanner.nextLine().replace(",", "."));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid GPA!");
                        break;
                    }

                    manager.addStudent(new Student(id, name, age, department, gpa));
                    break;

                case 2:

                    manager.viewStudents();
                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    String searchId = scanner.nextLine().trim();

                    Student student = manager.searchStudent(searchId);

                    if (student != null)
                        System.out.println(student);
                    else
                        System.out.println("Student not found.");

                    break;

                case 4:

                    System.out.print("Student ID: ");
                    String updateId = scanner.nextLine().trim();

                    System.out.print("New Name: ");
                    String newName = scanner.nextLine().trim();

                    System.out.print("New Age: ");
                    int newAge;

                    try {
                        newAge = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age!");
                        break;
                    }

                    System.out.print("New Department: ");
                    String newDepartment = scanner.nextLine().trim();

                    System.out.print("New GPA: ");
                    double newGpa;

                    try {
                        newGpa = Double.parseDouble(scanner.nextLine().replace(",", "."));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid GPA!");
                        break;
                    }

                    manager.updateStudent(updateId, newName, newAge, newDepartment, newGpa);
                    break;

                case 5:

                    System.out.print("Student ID: ");
                    String deleteId = scanner.nextLine().trim();

                    manager.deleteStudent(deleteId);
                    break;

                case 6:

                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:

                    System.out.println("Invalid option.");
            }
        }
    }
}
