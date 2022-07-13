package com.sparta.AlphaTeam.UserInterface;

import com.sparta.AlphaTeam.DataManagement.Employee;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    public void displayRecords(List<Employee> listToRead){
        for (Employee e : listToRead){
            System.out.println(e);
        }
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

    public void displayEmployee(Employee e){
        System.out.println(e);
    }
}
