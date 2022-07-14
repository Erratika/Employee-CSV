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
            return employeeStringList;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
//    public static List<String[]> streamReadFile (String fileName){
//        try {
//            List<String[]> employeeStringListArray = Files.lines(Path.of(fileName)).skip(1).map(s -> s.split(",")).toList();
//            return employeeStringListArray;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
