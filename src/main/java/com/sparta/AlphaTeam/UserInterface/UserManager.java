package com.sparta.AlphaTeam.UserInterface;

import com.sparta.AlphaTeam.Controller.Controller;
import com.sparta.AlphaTeam.DataManagement.Employee;
import com.sparta.AlphaTeam.UserInterface.Reader.Reader;
import com.sparta.AlphaTeam.core.FileEnum;

import java.io.File;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserManager {

    public void intro(){
        promt("Welcome to the file management and storage application!\n\nFirst, you will need to select a file");
    }
    public void userChoicePanel(){
        promt("your operation was successful!");

    }

    public void displayRecords(List<Employee> listToRead){
        for (Employee e : listToRead){
            System.out.println(e);
        }
    }
    public List<String> readFile(String filePath){
        //return Reader.readFile(filePath);
        return Reader.streamReadFile(filePath);
    }

    public void promt(String string){
        System.out.println(string);
    }

    public int getInputInt() throws ArithmeticException{
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    public int getUserThread(){
        promt("How many threads would you like to use?");
        return ChooseTools.getUserArrayLength();
    }


    public String getInputString() throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        String temp = null;
        try{
            temp = sc.nextLine();
        }catch(InputMismatchException e){
            e.printStackTrace();
        }
        return temp;//users decision
    }
    public FileEnum getFileENumber(){
        FileEnum fileEnum;
        promt("Please select a file to use by typing its number:");
        for (FileEnum s : FileEnum.values()){ // prints a list to the user of all enums in the list representing the different sort methods
            System.out.println(s.getEnumKey()+ ". " +s.getFileName());
        }

        fileEnum= ChooseTools.getUserEnum(); // selection module to return an enum for storage related to the list available
        return  fileEnum;
    }
    private static class ChooseTools{
        public static int actionChoice(){
            boolean userChoosing=true;
            Scanner scanner = new Scanner(System.in);
            int userValue=0;
            while (userChoosing) {
                System.out.println("you may choose a new operation by typing its' number: \n1. View clean records \n2. View unsorted records" +
                                "\n3. view all dirty records\n4. view records with invalid date\n5.view records witH missing fields\n" +
                        "6. view records with an incorrect date\n7. push clean records to the database\n8. retrieve records from database\n9. view records received from database\n10.choose a new file");
                userValue= StringConverter.stringToInt(scanner.next()); // uses converter to only return a positive int, and loop refuses a null array.
                if (userValue>=1 && userValue<=10){
                    userChoosing=false;
                }
            }
            return  userValue;
        }
        public static int getUserArrayLength(){
            boolean userChoosing=true;
            Scanner scanner = new Scanner(System.in);
            int userValue=1;
            while (userChoosing) {
                System.out.println("Please input an integer of value 1 or greater");
                userValue= StringConverter.stringToInt(scanner.next()); // uses converter to only return a positive int, and loop refuses a null array.
                if (userValue != 0){
                    userChoosing=false;
                }
            }
            return  userValue;
        }
        public static FileEnum getUserEnum(){
            Scanner scanner = new Scanner(System.in);
            FileEnum fileEnum=FileEnum.EMPLOYEERECORDS1;
            boolean userChoosing = true;
            String userInput;
            int userInputAsInt;

            while (userChoosing) {
                userInput = scanner.next();
                userInputAsInt= StringConverter.stringToInt(userInput); // personalised string-to int converter, reads for any ints and always returns positive
                for (FileEnum s : FileEnum.values()){ // checks through the list of enums to see if the input key matches user input key then returns relevant enum
                    if (s.getEnumKey()==userInputAsInt){
                        userChoosing=false;
                        fileEnum=s;
                    }
                }
                if (userChoosing){
                    System.out.println("please check you entered a valid number\n \nPlease enter a number corresponding to a file");
                }
            }
            return fileEnum;
        }

    }
    public static class StringConverter {
        public static int stringToInt(String inputString){
            StringBuilder stringBuilder= new StringBuilder(inputString.length());
            stringBuilder.append(0);
            char [] inputAsCharArray = inputString.toCharArray();
            // char value 48-57 are numerics
            for (char c : inputAsCharArray){
                if (c>= 48 && c<=57){
                    stringBuilder.append(c);
                }
            }
            // System.out.println(stringBuilder);
            return Integer.parseInt(stringBuilder.toString());
        }
    }
}

