package com.edu.model;

import com.edu.constants.EnumAcademicRanking;

import java.time.LocalDate;

public class Student extends Person {

    private String code;
    private String school;
    private int startYearOfCollege;
    private float gpa;

    private EnumAcademicRanking academicRanking;

    public Student() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getStartYearOfCollege() {
        return startYearOfCollege;
    }

    public void setStartYearOfCollege(int startYearOfCollege) {
        this.startYearOfCollege = startYearOfCollege;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public EnumAcademicRanking getAcademicRanking() {
        return academicRanking;
    }

    public void setAcademicRanking(EnumAcademicRanking academicRanking) {
        this.academicRanking = academicRanking;
    }

    @Override
    public String toString() {
        return "\nid = " + super.getId() +
                ", fullName= '" + super.getFullName() + '\'' +
                ", dateOfBirth= " + super.getDateOfBirth() +
                ", address= " + super.getAddress() +
                ", height= " + super.getHeight() +
                ", weight= " + super.getWeight() +
                "code= " + code +
                ", school= " + school +
                ", startYearOfCollege= " + startYearOfCollege +
                ", gpa= " + gpa +
                ", academic ranking = " + academicRanking.getDescription()
                ;
    }
}
