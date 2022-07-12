package com.sparta.alphateam.UserInterface.Reader;

import com.sparta.alphateam.DataManagement.Employee;

import java.util.List;

public class UserManager {
    public void displayRecords(List<Employee> listToRead){
        for (Employee e : listToRead){
            System.out.println(e);
        }
    }
}
