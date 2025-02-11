package StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private final Map<String, Student> students;

    public StudentSystem() {
        this.students = new HashMap<>();
    }

    private static String getStudentInfo(Student student, double grade) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s is %s years old.", student.getName(), student.getAge()));

        if (grade >= 5.00) {
            sb.append(" Excellent student.");
        } else if (grade >= 3.50) {
            sb.append(" Average student.");
        } else {
            sb.append(" Very nice person.");
        }
        return sb.toString();
    }

    public void parseCommand(String[] args) {
        String command = args[0];
        String name = args[1];
        switch (command) {
            case "Create": {
                int age = Integer.parseInt(args[2]);
                double grade = Double.parseDouble(args[3]);
                createAndRegisterStudent(name, age, grade);
                break;
            }
            case "Show": {
                if (!showStudent(name).equals("Student not found!")) {
                    System.out.println(showStudent(name));
                }
                break;
            }
            default: {
                throw new IllegalArgumentException("No such command " + command);
            }
        }
    }

    private String showStudent(String name) {
        Student student = students.get(name);
        if (student == null) {
            return "Student not found!";
        }
        return getStudentInfo(student, student.getGrade());
    }

    private void createAndRegisterStudent(String name, int age, double grade) {
        Student student = new Student(name, age, grade);
        students.putIfAbsent(name, student);
    }
}
