package com.nju;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "学生")
public class Student {
    @XmlElement(name = "学生个人信息")
    private StudentPersonInfo studentPersonInfos;
    @XmlElement(name = "学生分数")
    private StudentScores studentCourseScores;

    public Student(StudentPersonInfo studentPersonInfos, StudentScores studentCourseScores) {
        this.studentPersonInfos = studentPersonInfos;
        this.studentCourseScores = studentCourseScores;
    }

    public Student() {


    }

//    @XmlElement(name="学生个人信息")
//    public StudentPersonInfo getStudentPersonInfoList() {
//        return studentPersonInfos;
//    }
//
//    public void setStudentPersonInfos(StudentPersonInfo studentPersonInfos) {
//        this.studentPersonInfos = studentPersonInfos;
//    }
//

    public StudentScores returnList() {
        return studentCourseScores;
    }
//
//    public void setStudentCourseScores(StudentScores studentCourseScores) {
//        this.studentCourseScores = studentCourseScores;
//    }


}
