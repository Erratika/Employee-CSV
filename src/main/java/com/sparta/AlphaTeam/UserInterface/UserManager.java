package com.sparta.AlphaTeam.UserInterface;

import com.sparta.AlphaTeam.DataManagement.Employee;
import com.sparta.AlphaTeam.UserInterface.Reader.Reader;
import com.sparta.AlphaTeam.core.FileEnum;

import java.io.File;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    public void displayRecords(List<Employee> listToRead){
        for (Employee e : listToRead){
            System.out.println(e);
        }
    }
    public List<String> readFile(String filePath){
        return Reader.readFile(filePath);
    }

    public void promt(String string){
        System.out.println(string);
    }
    public void promt(int x){
        System.out.println(x);
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
        /*Scanner sc = new Scanner(System.in);
        FileEnum file = null;
        boolean userChoosing = true;
        while(userChoosing){
            int fileNumber = sc.nextInt();
            for(FileEnum s: FileEnum.values()){
                if(s.getEnumKey() == fileNumber){
                    userChoosing = false;
                    file = s;
                }
            }
            if (userChoosing){
                promt("Please enter a valid number corresponding to a File path");
            }
        }
        return file;*/
        FileEnum fileEnum;
        System.out.println("Please select a file to use by typing its number:");
        for (FileEnum s : FileEnum.values()){ // prints a list to the user of all enums in the list representing the different sort methods
            System.out.println(s.getEnumKey()+ ". " +s.getFileName());
        }

        fileEnum= ChooseTools.getUserEnum(); // selection module to return an enum for storage related to the list available
        return  fileEnum;
    }
    private static class ChooseTools{
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

