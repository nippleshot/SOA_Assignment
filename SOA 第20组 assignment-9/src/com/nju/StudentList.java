package com.nju;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement(name="学生列表")
public class StudentList {


    @XmlElement(name = "学生")
    private List<Student> Students;


    public StudentList(List<Student> students) {
        Students = students;
    }

    //    public List<Student> getStudents() {
//        if(Students==null){
//            Students=new ArrayList<Student>();
//        }
//        return Students;
//    }
//
//    public void setStudents(List<Student> students) {
//        Students = students;
//    }
    public StudentList() {

    }


    public StudentScores selectAll() {

        List<CourseScore> newCS=new ArrayList<CourseScore>();
        StudentScores Ss=new StudentScores(newCS);
        for(Student s:Students){
            Ss.combine(s.returnList());

        }
        return Ss;
    }
}
