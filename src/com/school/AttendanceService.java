package com.school;

import java.util.*;

public class AttendanceService {

    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    // Constructor
    public AttendanceService(FileStorageService storageService) {
        this.storageService = storageService;
        this.attendanceLog = new ArrayList<>();
    }

    // ✅ 1. markAttendance using Student and Course objects
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
        System.out.println("Marked attendance: "
                + student.getName() + " in " + course.getCourseName() + " -> " + status);
    }

    // ✅ 2. markAttendance using IDs
    public void markAttendance(int studentId, int courseId, String status,
                               List<Student> allStudents, List<Course> allCourses) {
        Student student = findStudentById(studentId, allStudents);
        Course course = findCourseById(courseId, allCourses);
        if (student != null && course != null) {
            markAttendance(student, course, status);
        } else {
            System.out.println("⚠️ Could not find Student or Course for IDs: "
                    + studentId + ", " + courseId);
        }
    }

    // 🔍 Helper methods
    private Student findStudentById(int id, List<Student> students) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    private Course findCourseById(int id, List<Course> courses) {
        for (Course c : courses) {
            if (c.getCourseId() == id) return c;
        }
        return null;
    }

    // 📋 Display methods
    public void displayAttendanceLog() {
        System.out.println("\n=== Full Attendance Log ===");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
            System.out.println("-----------------------");
        }
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("\n=== Attendance for Student: " + student.getName() + " ===");
        for (AttendanceRecord record : attendanceLog) {
            if (record.getStudent().getId() == student.getId()) {
                record.displayRecord();
                System.out.println("-----------------------");
            }
        }
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("\n=== Attendance for Course: " + course.getCourseName() + " ===");
        for (AttendanceRecord record : attendanceLog) {
            if (record.getCourse().getCourseId() == course.getCourseId()) {
                record.displayRecord();
                System.out.println("-----------------------");
            }
        }
    }

    // 💾 Save attendance log
    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
        System.out.println("✅ Attendance data saved to attendance_log.txt");
    }
}
