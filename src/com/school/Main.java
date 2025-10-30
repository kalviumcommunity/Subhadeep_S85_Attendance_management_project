package com.school;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- School Administration System (Part 10) ---");

        FileStorageService storageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storageService);

        // --- Register People ---
        Student s1 = new Student("Alice Wonderland", "Grade 10");
        Student s2 = new Student("Bob The Builder", "Grade 9");
        Student s3 = new Student("Charlie Brown", "Grade 11"); // extra student to test capacity

        Teacher t1 = new Teacher("Dr. Strange", "Physics");
        Teacher t2 = new Teacher("Prof. Turing", "Computer Science");
        Staff st1 = new Staff("Mr. Clean", "Janitor");

        registrationService.registerStudent(s1);
        registrationService.registerStudent(s2);
        registrationService.registerStudent(s3);
        registrationService.registerTeacher(t1);
        registrationService.registerTeacher(t2);
        registrationService.registerStaff(st1);

        // --- Create Courses (now includes capacity) ---
        registrationService.createCourse("Intro to Quantum Physics", 2);
        registrationService.createCourse("Advanced Algorithms", 1);

        // --- Enroll Students ---
        Course c1 = registrationService.findCourseById(101); // first created course
        Course c2 = registrationService.findCourseById(102); // second created course

        System.out.println("\n--- Enrollment Attempts ---");
        registrationService.enrollStudentInCourse(s1, c1); // success
        registrationService.enrollStudentInCourse(s2, c1); // success
        registrationService.enrollStudentInCourse(s3, c1); // should fail (capacity reached)
        registrationService.enrollStudentInCourse(s1, c2); // success
        registrationService.enrollStudentInCourse(s2, c2); // should fail (capacity reached)

        // --- Display School Directory ---
        System.out.println("\n--- School Directory ---");
        for (Person p : registrationService.getAllPeople()) {
            p.displayDetails();
        }

        // --- Display Courses with Enrollment Info ---
        System.out.println("\n--- Courses ---");
        for (Course c : registrationService.getCourses()) {
            c.displayDetails();
        }

        // --- Save Everything ---
        System.out.println("\n--- Saving All Data ---");
        registrationService.saveAllRegistrations();
        System.out.println("✅ All data saved successfully.");

        System.out.println("\nPart 10 complete. Check students.txt, teachers.txt, staff.txt, and courses.txt");
    }
}
