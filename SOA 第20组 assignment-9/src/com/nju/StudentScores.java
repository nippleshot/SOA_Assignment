package com.nju;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement(name = "学生分数")
public class StudentScores {
//    public CourseScoreList getCourseScoreList() {
//        return courseScores;
//    }
//
//    public void setCourseScores(CourseScoreList courseScores) {
//        this.courseScores = courseScores;
//    }
    @XmlElementWrapper(name = "课程成绩列表")
    @XmlElement(name = "课程成绩")
    private List<CourseScore> courseScores;

    public StudentScores(List<CourseScore> courseScores) {
        this.courseScores = courseScores;
    }

    public StudentScores() {
    }

    public List<CourseScore> findL(){
        return courseScores;
    }
    public void combine(StudentScores s){
        List<CourseScore> an=s.findL();
        for(CourseScore i:an){
            courseScores.add(i);
        }
    }


    public StudentScores findFail(){
        int i=0;
        List<CourseScore> Newcs=new ArrayList<CourseScore>();

        for(;i<courseScores.size();i=i+3){
            if(courseScores.get(i).score.score<60){
                Newcs.add(courseScores.get(i));
                Newcs.add(courseScores.get(i+1));
                Newcs.add(courseScores.get(i+2));
            }

        }

        StudentScores s=new StudentScores(Newcs);
        return s;

    }


}
