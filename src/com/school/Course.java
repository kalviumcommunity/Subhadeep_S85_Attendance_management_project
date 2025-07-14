package com.school;

public class Course {
//    courseId`, `courseName`, `setDetails()`, and `displayDetails()
    int courseId;
    String courseName;
    void setDetails(int courseId,String courseName){
        this.courseId=courseId;
        this.courseName=courseName;
    }
   void displayDetails(){
       System.out.println("Course id : "+courseId+" Course name : "+courseName);

   }
}
