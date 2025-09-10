package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("<---- People and Courses ---->\n");

        // Students
        Student[] students = new Student[3];
        students[0] = new Student("Subhadeep", "10th Grade");
        students[1] = new Student("Suman", "11th Grade");
        students[2] = new Student("Sagar", "12th Grade");

        System.out.print("Registered Students:\n");
        for (Student student : students) {
            student.displayDetails();
            System.out.println();
        }

        // Teacher
        Teacher teacher = new Teacher("Mr. Chikara", "OOPS");
        System.out.print("Teacher:\n");
        teacher.displayDetails();
        System.out.println();

        // Staff
        Staff staff = new Staff("John", "Librarian");
        System.out.print("Staff:\n");
        staff.displayDetails();
        System.out.println();

        // Courses
        Course[] courses = new Course[3];
        courses[0] = new Course("OOP");
        courses[1] = new Course("DBMS");
        courses[2] = new Course("Networks");

        System.out.print("Available Courses:\n");
        for (Course course : courses) {
            course.displayDetails();
        }

        // Attendance Records
        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(students[0].getId(), courses[0].getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students[1].getId(), courses[1].getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(students[2].getId(), courses[2].getCourseId(), "Late"));

        System.out.println("Attendance Records:\n");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
