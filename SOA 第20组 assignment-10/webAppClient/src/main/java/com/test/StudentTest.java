package com.test;

import com.exception.LocalClientException;
import com.studentservice.Student;
import com.studentservice.StudentService;
import com.studentservice.StudentServiceService;

import javax.xml.ws.WebServiceException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class StudentTest
{
    public static void main( String[] args ){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        PrintClass pc = new PrintClass();
        System.out.println( "Student Client Test" );
        try {
            StudentService studentService = new StudentServiceService().getStudentServicePort();

            pc.printStudent(studentService.identifyByStudentId("171250556", "12345"));
            //pc.printStudent(studentService.identifyByStudentId("171250551", "12345"));
            //pc.printStudent(studentService.identifyByStudentId("171250556", "wrong password"));

            pc.printStudent(studentService.identifyByIdCard("320488199907200134", "12345"));
            //pc.printStudent(studentService.identifyByIdCard("320488199907200135", "12345"));
            //pc.printStudent(studentService.identifyByIdCard("320488199907200134", "wrong password"));

            System.out.println(studentService.identifyDepartment("171250556"));
            //System.out.println(studentService.identifyDepartment("171250551"));

            System.out.println(studentService.identifyDormitory("171250556"));
            //System.out.println(studentService.identifyDormitory("171250551"));
            //

            System.out.println(studentService.identifyStudentStatus("171250556"));
            //System.out.println(studentService.identifyStudentStatus("171250551"));

            pc.printStudent(studentService.getStudentInfo("171250556"));
            //pc.printStudent(studentService.getStudentInfo("171250551"));

            ArrayList<Student> studentList = new ArrayList<>();
            Student newStudent = new Student();
            newStudent.setName("ZTZ");
            newStudent.setGender("Male");
            newStudent.setBirthday("1999-05-03");
            newStudent.setPersonId("401920199905034957");
            newStudent.setDepartment("SE");
            newStudent.setDormitory("3A214");
            newStudent.setStudentId("171250555");
            newStudent.setSchoolYear("2017");
            newStudent.setSchoolStatus("true");

            Student errorStudent = new Student();
            errorStudent.setName("ZTZ");
            errorStudent.setGender("male");
            errorStudent.setBirthday("1999-05-03");
            errorStudent.setPersonId("40192019990503");
            errorStudent.setDepartment("SE");
            errorStudent.setDormitory("3A214");
            errorStudent.setStudentId("17125055");
            errorStudent.setSchoolYear("217");
            errorStudent.setSchoolStatus("teue");


            studentList = (ArrayList<Student>) studentService.addStudentInfo(newStudent);
            //studentList = (ArrayList<Student>) studentService.addStudentInfo(ErrorStudent);
            newStudent.setName("ZTQ");
            studentList = (ArrayList<Student>) studentService.changeStudentInfo(newStudent);
            studentList = (ArrayList<Student>) studentService.deleteStudentInfo("171250555");
            //studentList = (ArrayList<Student>) studentService.deleteStudentInfo("171250111");


            for(int i = 0;i<studentList.size();i++){
                pc.printStudent(studentList.get(i));
            }

        }catch (WebServiceException wse){
            System.out.println("ERROR: Server not connected");
            wse.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}