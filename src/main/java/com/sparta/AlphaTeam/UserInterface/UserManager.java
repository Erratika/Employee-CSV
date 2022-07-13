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
}

