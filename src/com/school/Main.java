package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Method to display the entire school directory
    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n--- School Directory ---");
        for (Person person : people) {
            person.displayDetails();  // Polymorphic call
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School Administration & Attendance System ---");

        // --- Data Setup ---
        List<Student> students = new ArrayList<>();
        Student s1 = new Student("Alice Wonderland", "Grade 10");
        Student s2 = new Student("Bob The Builder", "Grade 9");
        students.add(s1);
        students.add(s2);

        List<Teacher> teachers = new ArrayList<>();
        Teacher t1 = new Teacher("Dr. Strange", "Physics");
        Teacher t2 = new Teacher("Prof. Turing", "Computer Science");
        teachers.add(t1);
        teachers.add(t2);

        List<Staff> staff = new ArrayList<>();
        Staff st1 = new Staff("Mr. Clean", "Janitor");
        staff.add(st1);

        List<Course> courses = new ArrayList<>();
        Course c1 = new Course("Intro to Quantum Physics");
        Course c2 = new Course("Advanced Algorithms");
        courses.add(c1);
        courses.add(c2);

        // --- Create Initial Attendance Records (Part 7 style) ---
        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(s1, c1, "Present"));
        attendanceLog.add(new AttendanceRecord(s2, c1, "Absent"));
        attendanceLog.add(new AttendanceRecord(s1, c2, "Present"));

        // --- School Directory ---
        List<Person> schoolPeople = new ArrayList<>();
        schoolPeople.addAll(students);
        schoolPeople.addAll(teachers);
        schoolPeople.addAll(staff);

        displaySchoolDirectory(schoolPeople);

        // --- Courses ---
        System.out.println("\n--- Courses ---");
        for (Course c : courses) {
            c.displayDetails();
        }

        // --- Attendance Log (old part) ---
        System.out.println("\n--- Attendance Log ---");
        for (AttendanceRecord ar : attendanceLog) {
            ar.displayRecord();
            System.out.println("---------------------------");
        }

        // --- Saving Data ---
        System.out.println("\n--- Saving Data to Files ---");
        FileStorageService storageService = new FileStorageService();

        // Filter Students from schoolPeople
        List<Student> studentData = new ArrayList<>();
        for (Person p : schoolPeople) {
            if (p instanceof Student) {
                studentData.add((Student) p);
            }
        }

        storageService.saveData(studentData, "students.txt");
        storageService.saveData(courses, "courses.txt");
        storageService.saveData(attendanceLog, "attendance_log.txt");

        System.out.println("\nSession 7: School Directory & Attendance with Object References Complete.");
        System.out.println("Check students.txt, courses.txt, and attendance_log.txt for output.");

        // =====================================================
        // === Part 08: AttendanceService Integration Below ====
        // =====================================================

        System.out.println("\n--- Part 08: Using AttendanceService ---");

        // Create AttendanceService using same FileStorageService
        AttendanceService attendanceService = new AttendanceService(storageService);

        // Use both overloaded markAttendance methods
        attendanceService.markAttendance(s1, c1, "Present");
        attendanceService.markAttendance(s2, c2, "Absent");
        attendanceService.markAttendance(s2.getId(), c1.getCourseId(), "Present", students, courses);

        // Display logs using different versions
        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(s1);
        attendanceService.displayAttendanceLog(c2);

        // Save attendance log
        attendanceService.saveAttendanceData();

        System.out.println("\n✅ Part 08 Complete: AttendanceService tested and data saved successfully.");
        System.out.println("Check attendance_log.txt for updated records.");
    }
}
