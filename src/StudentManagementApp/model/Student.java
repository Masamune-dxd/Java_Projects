package StudentManagementApp.model;

public class Student {
    private String studentId;
    private String name;
    private int age;
    private String grade;

    public Student(String studentId, String name, int age, String grade) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGrade() { return grade; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGrade(String grade) { this.grade = grade; }

    @Override
    public String toString() {
        return "Student ID: " + studentId +
               ", Name: " + name +
               ", Age: " + age +
               ", Grade: " + grade;
    }
}