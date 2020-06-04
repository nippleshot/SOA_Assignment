package com.nju;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "hello")
public class test {
    @XmlElement
    String a;
    @XmlElement
    String b;
    @XmlElement
    String x;
    @XmlElement(name = "?")
    List<Score> s;

    public test(String a, String b, String x,List<Score> s) {
        this.a = a;
        this.b = b;
        this.x = x;
        this.s=s;
    }

    public test() {
    }

//    public String getA() {
//        return a;
//    }
//
//    public void setA(String a) {
//        this.a = a;
//    }
//
//    public String getB() {
//        return b;
//    }
//
//    public void setB(String b) {
//        this.b = b;
//    }
//
//    public String getX() {
//        return x;
//    }
//
//    public void setX(String x) {
//        this.x = x;
//    }
}
