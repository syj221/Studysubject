package com.example.timetable.activity;

public class BasicInfo {
    private String school;
    private String department;
    private int enrollmentYear;

    public BasicInfo(String school, String department, int enrollmentYear) {
        this.school = school;
        this.department = department;
        this.enrollmentYear = enrollmentYear;
    }

    // Getters and Setters
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }
}