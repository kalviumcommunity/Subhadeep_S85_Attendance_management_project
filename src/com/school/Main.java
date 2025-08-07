package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("<----Student and courses details---->\n");

        Student[] students = new Student[3];
        students[0] = new Student("Subhadeep");
        students[1] = new Student("Suman");
        students[2] = new Student("Sagar");

        System.out.println("Registered Student:\n");
        for (Student student : students) {
            student.display();
        }

        Course[] courses = new Course[3];
        courses[0] = new Course("OOP");
        courses[1] = new Course("DBMS");
        courses[2] = new Course("Networks");

        System.out.println("\nAvailable Courses:\n");
        for (Course course : courses) {
            course.displayDetails();
        }

        // Attendance Records
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        attendanceLog.add(new AttendanceRecord(students[0].getStudentId(), courses[0].getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students[1].getStudentId(), courses[1].getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(students[2].getStudentId(), courses[2].getCourseId(), "Late")); // Invalid

        System.out.println("\nAttendance Records:\n");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
