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

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Department: ");
                    String department = scanner.nextLine();

                    System.out.print("GPA: ");
                    double gpa = scanner.nextDouble();

                    manager.addStudent(new Student(id, name, age, department, gpa));
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    Student student = manager.searchStudent(scanner.nextInt());

                    if (student != null)
                        System.out.println(student);
                    else
                        System.out.println("Student not found.");

                    break;

                case 4:
                    System.out.print("Student ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("New Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("New Department: ");
                    String newDepartment = scanner.nextLine();

                    System.out.print("New GPA: ");
                    double newGpa = scanner.nextDouble();

                    manager.updateStudent(updateId, newName, newAge, newDepartment, newGpa);
                    break;

                case 5:
                    System.out.print("Student ID: ");
                    manager.deleteStudent(scanner.nextInt());
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