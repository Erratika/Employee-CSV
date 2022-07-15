package com.sparta.AlphaTeam.DataManagement;

import com.sparta.AlphaTeam.DataManagement.Database.ConnectionFactory;
import com.sparta.AlphaTeam.DataManagement.Database.DAO;
import com.sparta.AlphaTeam.DataManagement.Database.DatabaseInit;
import com.sparta.AlphaTeam.DataManagement.Database.EmployeeDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddTask implements Runnable{
    Employee[] employeeArray;

    public AddTask(Employee[] employeeArray) {

        this.employeeArray = employeeArray;
    }

    @Override
    public void run() {
        DAO dataAccess = new EmployeeDAO();
        for (Employee e : employeeArray){
            dataAccess.add(e);
        }
        /*Connection connection = ConnectionFactory.getConnection();
        try {Statement statement = connection.createStatement();
            for (Employee employee: employeeArray) {


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/



    }
}
