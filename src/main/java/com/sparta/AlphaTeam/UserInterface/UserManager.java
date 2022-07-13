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
    public FileEnum getFileNumber(){
        Scanner sc = new Scanner(System.in);
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
        return file;
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

