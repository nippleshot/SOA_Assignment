package com.test;

import com.studentservice.Student;

public class PrintClass {
    public void printStudent(Student student){
        String resStr = "";
        resStr += "Name: "+student.getName()+"\n";
        resStr += "Gender: "+student.getGender()+"\n";
        resStr += "Birthday: "+student.getBirthday()+"\n";
        resStr += "Person Id: "+student.getPersonId()+"\n";
        resStr += "Department: "+student.getDepartment()+"\n";
        resStr += "Dormitory: "+student.getDormitory()+"\n";
        resStr += "Student Id: "+student.getStudentId()+"\n";
        resStr += "School Year: "+student.getSchoolYear()+"\n";
        resStr += "School Status: "+student.getSchoolStatus()+"\n";
        System.out.println(resStr+"\n");
    }
}
