package com.school;

import java.util.*;

public class RegistrationService {

    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Staff> staffMembers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    private FileStorageService fileStorageService;

    public RegistrationService(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    // --- Registration Methods ---
    public void registerStudent(Student s) { students.add(s); }
    public void registerTeacher(Teacher t) { teachers.add(t); }
    public void registerStaff(Staff s) { staffMembers.add(s); }

    // Updated createCourse() — now takes course name and capacity
    public void createCourse(String name, int capacity) {
        Course c = new Course(name, capacity);
        courses.add(c);
        System.out.println("✅ Course created: " + name + " (Capacity: " + capacity + ")");
    }

    // --- Getters ---
    public List<Student> getStudents() { return students; }
    public List<Teacher> getTeachers() { return teachers; }
    public List<Staff> getStaffMembers() { return staffMembers; }
    public List<Course> getCourses() { return courses; }

    // --- Finders ---
    public Student findStudentById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public Course findCourseById(int id) {
        return courses.stream().filter(c -> c.getCourseId() == id).findFirst().orElse(null);
    }

    // --- Enrollment ---
    public boolean enrollStudentInCourse(Student student, Course course) {
        boolean success = course.addStudent(student);
        if (success) {
            System.out.println("🎓 Enrollment successful: " + student.getName() + " -> " + course.getCourseName());
        } else {
            System.out.println("🚫 Enrollment failed: " + student.getName() + " -> " + course.getCourseName());
        }
        return success;
    }

    // --- Utility ---
    public List<Person> getAllPeople() {
        List<Person> people = new ArrayList<>();
        people.addAll(students);
        people.addAll(teachers);
        people.addAll(staffMembers);
        return people;
    }

    // --- Save All Data ---
    public void saveAllRegistrations() {
        fileStorageService.saveData(students, "students.txt");
        fileStorageService.saveData(teachers, "teachers.txt");
        fileStorageService.saveData(staffMembers, "staff.txt");
        fileStorageService.saveData(courses, "courses.txt");
        System.out.println("💾 All registration data saved successfully.");
    }
}
