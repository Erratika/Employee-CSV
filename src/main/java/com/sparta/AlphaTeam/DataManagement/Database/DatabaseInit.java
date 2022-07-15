package com.sparta.AlphaTeam.DataManagement.Database;

import com.sparta.AlphaTeam.DataManagement.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseInit {
    private static final Logger LOG = LogManager.getLogger(DatabaseInit.class);
    public static void init(){
        createDatabase();
        makeTable();
    }

    public static void makeTable(){
        Connection conn = ConnectionFactory.getConnection();
        try(Statement statement = conn.createStatement()){
            LOG.info("Dropping any existing \"employeees\" tables.");
            statement.executeUpdate("DROP TABLE IF EXISTS employees");
            LOG.info("\"employees\" table dropped.");
            LOG.info("Creating a new \"employees\" table.");
            String sql = "CREATE TABLE `employees`" +
                    " (`id` int NOT NULL," +
                    "`prefix` varchar(10) DEFAULT NULL," +
                    "`first_name` varchar(45) DEFAULT NULL," +
                    "`middle_initial` char(1) DEFAULT NULL," +
                    "`last_name` varchar(45) DEFAULT NULL," +
                    "`gender` char(1) DEFAULT NULL," +
                    "`email` varchar(45) DEFAULT NULL," +
                    "`date_of_birth` date DEFAULT NULL," +
                    "`date_of_joining` date DEFAULT NULL," +
                    "`salary` int DEFAULT NULL," +
                    " PRIMARY KEY (`id`)," +
                    " UNIQUE KEY `email_UNIQUE` (`email`))" +
                    " ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 " +
                    "COLLATE=utf8mb4_0900_ai_ci";
        statement.executeUpdate(sql);
            LOG.info("New \"employees\" table created.");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void createDatabase(){
        Connection connection = ConnectionFactory.getConnection();
        try(Statement statement = connection.createStatement()) {
            LOG.info("Dropping \"employees\" database if it exists.");
            statement.executeUpdate("DROP DATABASE IF EXISTS employees");
            LOG.info("Creating and using new \"employees\" database.");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS employees");
            statement.executeUpdate("USE employees");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
