package com.school;

public class AttendanceRecord implements Storable {
    private Student student;   // Changed from int studentId
    private Course course;     // Changed from int courseId
    private String status;     // e.g., "Present", "Absent"

    // Updated constructor to accept Student and Course objects
    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;

        // Basic validation for status
        if ("Present".equalsIgnoreCase(status) || "Absent".equalsIgnoreCase(status)) {
            this.status = status;
        } else {
            this.status = "Invalid"; // Default for invalid input
            System.out.println("Warning: Invalid attendance status provided. Set to 'Invalid'.");
        }
    }

    // Getters
    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    // Updated displayRecord() to show richer details
    public void displayRecord() {
        System.out.println("Attendance Record:");
        System.out.println(" Student: " + student.getName() + " (ID: " + student.getId() + ")");
        System.out.println(" Course: " + course.getCourseName() + " (ID: " + course.getCourseId() + ")");
        System.out.println(" Status: " + status);
    }

    @Override
    public String toDataString() {
        // Format: studentId,courseId,status (for file saving)
        return student.getId() + "," + course.getCourseId() + "," + status;
    }
}
