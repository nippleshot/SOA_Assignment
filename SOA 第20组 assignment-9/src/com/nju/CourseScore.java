package com.nju;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class CourseScore {
    @XmlElement(name = "成绩")
    public Score score;
    @XmlAttribute(name = "成绩性质")
    public String ScoreType;
    @XmlAttribute(name = "课程编号")
    public String courseId;


    public CourseScore(Score score, String scoreType, String courseId) {
        this.score = score;
        ScoreType = scoreType;
        this.courseId = courseId;
    }

    public CourseScore() {
    }




    //    public Score getScoreList() {
//        return score;
//    }
//
//    public void setScore(Score score) {
//        this.score = score;
//    }
//
//    public String getScoreType() {
//        return ScoreType;
//    }
//
//    public void setScoreType(String scoreType) {
//        ScoreType = scoreType;
//    }
//
//    public String getCourseIds() {
//        return courseId;
//    }
//
//    public void setCourseId(String courseId) {
//        this.courseId = courseId;
//    }
}
