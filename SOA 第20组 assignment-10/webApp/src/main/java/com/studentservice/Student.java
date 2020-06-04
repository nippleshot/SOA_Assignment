package com.studentservice;

import java.lang.ref.SoftReference;
import java.util.Date;

public class Student {
    private String name;
    private String gender;
    private String birthday;
    private String personId;
    private String department;
    private String dormitory;
    private String studentId;
    private String schoolYear;
    private String schoolStatus;

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPersonId() {
        return personId;
    }

    public String getDepartment() {
        return department;
    }

    public String getDormitory() {
        return dormitory;
    }

    public String getSchoolStatus() {
        return schoolStatus;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public void setSchoolStatus(String schoolStatus) {
        this.schoolStatus = schoolStatus;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
