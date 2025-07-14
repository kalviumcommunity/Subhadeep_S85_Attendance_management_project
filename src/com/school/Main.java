package com.school;

public class Main {
    public static void main(String[] args) {
        Student[] Students=new Student[2];
        Students[0] = new Student();
        Students[1] = new Student();
        Students[0].setDetails(18,"Subhadeep");
        Students[1].setDetails(19,"Suman");
        for(int i=0;i<2;i++){
            Students[i].display();
        }
Course[] courses=new Course[2];
        courses[0]=new Course();
        courses[1]=new Course();
courses[0].setDetails(1,"OOP");
courses[1].setDetails(2,"DBMS");
        for(int i=0;i<2;i++){
            courses[i].displayDetails();
        }
    }
}
