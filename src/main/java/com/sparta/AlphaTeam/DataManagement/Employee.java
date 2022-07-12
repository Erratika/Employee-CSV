package com.sparta.AlphaTeam.DataManagement;

import java.util.Date;

public class Employee {

    private int id;
    private String prefix;
    private String fName;
    private String mName;
    private String lName;
    private String gender;
    private String email;
    private Date dateOfBirth;
    private Date joinDate;
    private int salary;

    public Employee(int id, String prefix, String fName, String mName, String lName, String gender, String email, Date dob,
                    Date join, int salary){
        this.id= id;
        this.prefix= prefix;
        this.fName= fName;
        this.mName = mName;
        this.lName= lName;
        this.gender= gender;
        this.email=email;
        this.dateOfBirth= dob;
        this.joinDate= join;
        this.salary= salary;
    }
    public Employee(){

    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public int getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getGender() {
        return gender;
    }

    public String getlName() {
        return lName;
    }

    public String getmName() {
        return mName;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }
}


