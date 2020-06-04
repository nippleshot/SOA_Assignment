package com.nju;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


public class StudentPersonInfo {
    @XmlElement(name = "个人信息")
    private PersonInfo personInfo;
    @XmlElement(name = "学号")
    private String StudentId;
    @XmlElement(name = "入学年级")
    private String grade;
    @XmlElement(name = "学籍状态")
    private String State;


    public StudentPersonInfo(PersonInfo personInfo, String studentId, String grade, String state) {
        this.personInfo = personInfo;
        StudentId = studentId;
        this.grade = grade;
        State = state;
    }

    public StudentPersonInfo() {
    }
//    @XmlElement(name = "个人信息")
//    public PersonInfo getPersonInfos() {
//        return personInfo;
//    }
//
//    public void setPersonInfo(PersonInfo personInfo) {
//        this.personInfo = personInfo;
//    }
//
//    public String getStudentId() {
//        return StudentId;
//    }
//
//    public void setStudentId(String studentId) {
//        StudentId = studentId;
//    }
//    @XmlElement(name = "入学年级")
//    public String getGrades() {
//        return grade;
//    }
//
//    public void setGrade(String grade) {
//        this.grade = grade;
//    }
//
//    public String getState() {
//        return State;
//    }
//
//    public void setState(String state) {
//        State = state;
//    }
}
