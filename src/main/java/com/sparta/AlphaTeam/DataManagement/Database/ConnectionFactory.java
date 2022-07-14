package com.sparta.AlphaTeam.DataManagement.Database;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory implements AutoCloseable {
    public static Connection connection=null;


    public static Connection getConnection(){
        Properties dbProps = new Properties();
        try {
            dbProps.load(new FileReader("src/main/resources/database.properties"));
        } catch (IOException e) {
            e.printStackTrace();

        }


        if (connection == null) {
            try {
                connection = DriverManager.getConnection(dbProps.getProperty("db.url"), dbProps.getProperty("db.username"), dbProps.getProperty("db.password"));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static void closeConnection(){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
