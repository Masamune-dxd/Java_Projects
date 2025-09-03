package StudentManagementApp.manager;

import StudentManagementApp.model.Student;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) {
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(student.getStudentId())) {
                System.out.println("Error: Student with ID " + student.getStudentId() + " already exists.");
                return false;
            }
        }
        students.add(student);
        System.out.println("Student added successfully: " + student.getName());
        return true;
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered yet.");
            return;
        }
        System.out.println("\n--- List of All Students ---");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("----------------------------");
    }

    public Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }

    public boolean updateStudent(String studentId, String newName, int newAge, String newGrade) {
        Student studentToUpdate = findStudentById(studentId);
        if (studentToUpdate != null) {
            studentToUpdate.setName(newName);
            studentToUpdate.setAge(newAge);
            studentToUpdate.setGrade(newGrade);
            System.out.println("Student with ID " + studentId + " updated successfully.");
            return true;
        } else {
            System.out.println("Error: Student with ID " + studentId + " not found.");
            return false;
        }
    }

    public boolean deleteStudent(String studentId) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                iterator.remove();
                System.out.println("Student with ID " + studentId + " deleted successfully.");
                return true;
            }
        }
        System.out.println("Error: Student with ID " + studentId + " not found for deletion.");
        return false;
    }

    public int getNumberOfStudents() {
        return students.size();
    }
}