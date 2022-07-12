package com.sparta.AlphaTeam.UserInterface.Reader;

import com.sparta.AlphaTeam.DataManagement.Employee;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static void readFile(String employeeFile) {

        try(FileReader fileReader = new FileReader(employeeFile);
            BufferedReader bufferedFileReader = new BufferedReader(fileReader);) {
            String line;
            while ((line = bufferedFileReader.readLine()) != null) {
                String [] records = line.split(",");
                for (int i = 0; i < records.length; i++) {
                    records[i] = String.valueOf(null);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
