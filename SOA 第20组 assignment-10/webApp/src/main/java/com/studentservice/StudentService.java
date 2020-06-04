package com.studentservice;

import com.exception.RemoteServerException;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;

@WebService
public class StudentService {
    private static String srcPath = "F:\\study\\webApp\\src\\studentList.xml";
    private DocumentProcess documentProcess = new DocumentProcess(srcPath);

    public Student identifyByStudentId(String studentId, String password) throws RemoteServerException {
        return documentProcess.identifyByStudentId(studentId, password);
    }

    public Student identifyByIdCard(String personId, String password) throws RemoteServerException {
        return documentProcess.identifyByIdCard(personId, password);
    }

    public String identifyStudentStatus(String studentId) throws RemoteServerException {
        return documentProcess.identifyStudentStatus(studentId);
    }

    public String identifyDepartment(String studentId) throws RemoteServerException {
        return  documentProcess.identifyDepartment(studentId);
    }

    public String identifyDormitory(String studentId) throws RemoteServerException {
        return documentProcess.identifyDormitory(studentId);
    }

    public Student getStudentInfo(String studentId) throws RemoteServerException {
        return documentProcess.getStudentInfo(studentId);
    }

    public ArrayList<Student> addStudentInfo(Student student) throws RemoteServerException {
        return documentProcess.addStudentInfo(student);
    }

    public ArrayList<Student> deleteStudentInfo(String studentId) throws RemoteServerException {
        return documentProcess.deleteStudentInfo(studentId);
    }

    public ArrayList<Student> changeStudentInfo(Student student) throws RemoteServerException {
        return documentProcess.changeStudentInfo(student);
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/StudentService/",new StudentService());
        System.out.println("Student Service Server Start......");
    }
}
