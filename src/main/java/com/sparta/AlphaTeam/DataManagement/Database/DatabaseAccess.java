package com.sparta.AlphaTeam.DataManagement.Database;

import com.sparta.AlphaTeam.DataManagement.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*"CREATE TABLE `employees`" +
        " (`employee_id` int NOT NULL," +
        "`prefix` varchar(10) DEFAULT NULL," +
        "`first_name` varchar(45) DEFAULT NULL," +
        "`middle_initial` char(1) DEFAULT NULL," +
        "`last_name` varchar(45) DEFAULT NULL," +
        "`gender` char(1) DEFAULT NULL," +
        "`email` varchar(45) DEFAULT NULL," +
        "`date_of_birth` date DEFAULT NULL," +
        "`date_of_joining` date DEFAULT NULL," +
        "`salary` int DEFAULT NULL," +
        " PRIMARY KEY (`emplyee_id`)," +
        " UNIQUE KEY `email_UNIQUE` (`email`))" +
        " ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 " +
        "COLLATE=utf8mb4_0900_ai_ci";*/
public class DatabaseAccess {

    List<Employee> employeeList= new ArrayList<>();

    public List<Employee> getAllEmployees(){
        Connection conn = ConnectionFactory.getConnection();
        try {

            PreparedStatement stmt =conn.prepareStatement("SELECT * FROM employees ");
            ResultSet rs =stmt.executeQuery();
            while(rs.next()){
                employeeList.add(new Employee());
            }
            rs.first();
            int i=0;
            while (rs.next(){
                employeeList.get(i).setId(rs.getInt(1));
                i++;
            }
            rs.first()
            i=0



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }
    public void addEmployee(){

    }
    public void deleteEmployee(){

    }
    public void updateEmployee(){

    }
}
