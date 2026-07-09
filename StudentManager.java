import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    // Add Student
    public boolean addStudent(Student student) {

        if (searchStudent(student.getId()) != null) {
            return false;
        }

        students.add(student);
        return true;
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
    public boolean deleteStudent(String id) {

        Student student = searchStudent(id);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }

    // Update Student
    public boolean updateStudent(String id, String name, int age,
                                 String department, double gpa) {

        Student student = searchStudent(id);

        if (student != null) {

            student.setName(name);
            student.setAge(age);
            student.setDepartment(department);
            student.setGpa(gpa);

            return true;
        }

        return false;
    }

    // Get All Students (for JTable)
    public ArrayList<Student> getStudents() {
        return students;
    }

    // Total Students
    public int getStudentCount() {
        return students.size();
    }

    // Clear All Students (ileride kullanacağız)
    public void clearStudents() {
        students.clear();
    }
}
