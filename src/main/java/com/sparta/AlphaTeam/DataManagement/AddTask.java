package com.sparta.AlphaTeam.DataManagement;



public class AddTask implements Runnable{
    Employee[] employeeArray;

    public AddTask(Employee[] employeeArray) {
        this.employeeArray = employeeArray;
    }

    @Override
    public void run() {
        for (Employee employee: employeeArray) {


        }


    }
}
