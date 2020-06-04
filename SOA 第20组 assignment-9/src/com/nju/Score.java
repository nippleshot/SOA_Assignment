package com.nju;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Score {
    @XmlElement(name = "学号")
    public String StudentId;
    @XmlJavaTypeAdapter(IToSAdapter.class)
    @XmlElement(name = "得分")
    public Integer score;

    public Score(String studentId, int score) {
        StudentId = studentId;
        this.score = score;
    }


    public Score() {
    }
}
