package com.nju;

import javax.xml.bind.annotation.XmlElement;

public class PersonInfo {
    @XmlElement(name = "姓名")
    private String name;
    @XmlElement(name = "性别")
    private String sex;
    @XmlElement(name = "出生日期")
    private String birthday;
    @XmlElement(name = "身份证号")
    private String IDNumber;
    @XmlElement(name = "部门")
    private String Department;

    public PersonInfo(String name, String sex, String birthday, String IDNumber, String department) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.IDNumber = IDNumber;
        Department = department;
    }

    public PersonInfo() {
    }

//    public String getNames() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSexs() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    public String getBirthdays() {
//        return birthday;
//    }
//
//    public void setBirthday(String birthday) {
//        this.birthday = birthday;
//    }
//
//    public String getIDNumbers() {
//        return IDNumber;
//    }
//
//    public void setIDNumber(String IDNumber) {
//        this.IDNumber = IDNumber;
//    }
//
//    public String getDepartment() {
//        return Department;
//    }
//
//    public void setDepartment(String department) {
//        Department = department;
//    }
}
