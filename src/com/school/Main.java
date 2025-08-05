package com.school;

public class Main {
    public static void main(String[] args) {
        System.out.println("<----Student and courses details---->");
        System.out.println();
        Student[] students = new Student[3];
        students[0] = new Student("Subhadeep");
        students[1] = new Student("Suman");
        students[2] = new Student("Sagar");
        System.out.println("Registered Student :");
        System.out.println();
        for (Student student : students) {
            student.display();
        }

        Course[] courses = new Course[3];
        courses[0] = new Course("OOP");
        courses[1] = new Course("DBMS");
        courses[2] = new Course("Networks");
        System.out.println();
        System.out.println("Available courses :");
        System.out.println();
        for (Course course : courses) {
            course.displayDetails();
        }
    }
}
