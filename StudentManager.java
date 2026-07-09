import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    // Add Student
    public void addStudent(Student student) {

        if (searchStudent(student.getId()) != null) {
            System.out.println("A student with this ID already exists!");
            return;
        }

        students.add(student);
        System.out.println("Student added successfully!");
    }

    // View All Students
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Search Student
    public Student searchStudent(String id) {

        for (Student student : students) {

            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }

        return null;
    }

    // Delete Student
    public void deleteStudent(String id) {

        Student student = searchStudent(id);

        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Update Student
    public void updateStudent(String id, String name, int age, String department, double gpa) {

        Student student = searchStudent(id);

        if (student != null) {

            student.setName(name);
            student.setAge(age);
            student.setDepartment(department);
            student.setGpa(gpa);

            System.out.println("Student updated successfully!");

        } else {

            System.out.println("Student not found.");
        }
    }

    // Return all students (for Swing JTable later)
    public ArrayList<Student> getStudents() {
        return students;
    }
}
