package com.school;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("Subhadeep");
        students[1] = new Student("Suman");
        students[2] = new Student("Sagar");

        for (Student student : students) {
            student.display();
        }

        Course[] courses = new Course[3];
        courses[0] = new Course("OOP");
        courses[1] = new Course("DBMS");
        courses[2] = new Course("Networks");

        for (Course course : courses) {
            course.displayDetails();
        }
    }
}
