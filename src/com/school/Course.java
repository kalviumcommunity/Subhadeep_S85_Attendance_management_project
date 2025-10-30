package com.school;

import java.util.ArrayList;
import java.util.List;

public class Course implements Storable {
    private static int nextCourseIdCounter = 101;

    private int courseId;                 // Unique course ID
    private String courseName;            // Course name
    private int capacity;                 // Max number of students
    private List<Student> enrolledStudents; // Students enrolled in this course

    // --- Constructor ---
    public Course(String courseName, int capacity) {
        this.courseId = nextCourseIdCounter++; // Auto-increment and assign ID
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    // --- Getters ---
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public int getNumberOfEnrolledStudents() {
        return enrolledStudents.size();
    }

    // --- Enroll Student Method ---
    public boolean addStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            System.out.println("✅ " + student.getName() + " enrolled in " + courseName);
            return true;
        } else {
            System.out.println("⚠️ Cannot enroll " + student.getName() + " — " + courseName + " is full!");
            return false;
        }
    }

    // --- Display Method ---
    public void displayDetails() {
        System.out.println("Course ID: C" + this.courseId +
                ", Name: " + this.courseName +
                ", Capacity: " + this.capacity +
                ", Enrolled: " + enrolledStudents.size());
    }

    // --- File Persistence ---
    @Override
    public String toDataString() {
        // Format: courseId,courseName,capacity
        return courseId + "," + courseName + "," + capacity;
    }
}
