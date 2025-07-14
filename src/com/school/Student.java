package com.school;

public class Student {
    int StudentId;
    String name;
    void setDetails(int StudentId,String name){
        this.StudentId=StudentId;
        this.name=name;
    }
    void display(){
        System.out.println("Student id : "+StudentId+" Student name : "+name);
    }
}
