public class Student {

    private String id;
    private String name;
    private int age;
    private String department;
    private double gpa;

    public Student(String id, String name, int age, String department, double gpa) {
        this.id = id;
        this.name = name;
        setAge(age);
        this.department = department;
        setGpa(gpa);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getGpa() {
        return gpa;
    }

    // Setters
    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id.trim();
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        }
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age!");
        }
    }

    public void setDepartment(String department) {
        if (department != null && !department.trim().isEmpty()) {
            this.department = department.trim();
        }
    }

    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("GPA must be between 0.0 and 4.0");
        }
    }

    @Override
    public String toString() {
        return "-----------------------------\n" +
               "Student ID : " + id + "\n" +
               "Name       : " + name + "\n" +
               "Age        : " + age + "\n" +
               "Department : " + department + "\n" +
               "GPA        : " + String.format("%.2f", gpa) + "\n" +
               "-----------------------------";
    }
}
