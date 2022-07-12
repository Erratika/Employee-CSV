package com.sparta.AlphaTeam.DataManagement.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInit {

    public static void makeTable(){
        Connection conn = ConnectionFactory.getConnection();
        try(Statement statement = conn.createStatement()){
            statement.executeUpdate("DROP TABLE IF EXISTS employees");

            String sql = "CREATE TABLE `employees`" +
                    " (`emplyee_id` int NOT NULL," +
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
                    "COLLATE=utf8mb4_0900_ai_ci";
        statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }


        ConnectionFactory.closeConnection();
    }

}
