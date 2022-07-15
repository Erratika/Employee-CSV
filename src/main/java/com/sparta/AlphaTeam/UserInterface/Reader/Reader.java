package com.sparta.AlphaTeam.UserInterface.Reader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    public static List<String> readFile(String filePath) {

        try (Scanner scan = new Scanner(new FileReader(filePath)).useDelimiter("\r\n")) {
            List<String> employeeStringList = new ArrayList<>();
            String dataString;
            scan.nextLine();
            while (scan.hasNext()) {
                dataString = scan.next();
                employeeStringList.add(dataString);
            }
            System.out.println(employeeStringList);
            return employeeStringList;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    /*public static List<String> streamReadFile (String fileName){
        try {
            List<String> employeeList = new ArrayList<>();
            List<String[]> employeeStringListArray = Files.lines(Path.of(fileName)).skip(1).map(s -> s.split(",")).toList();
            for(String[] e: employeeStringListArray){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i<e.length; i++){
                    sb.append(e[i]);
                    sb.append(",");
                }
                //System.out.println(sb);
                employeeList.add(sb.toString());
            }
            return employeeList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
}
