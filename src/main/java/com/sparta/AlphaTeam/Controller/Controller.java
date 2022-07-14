package com.sparta.AlphaTeam.Controller;

import com.sparta.AlphaTeam.DataManagement.DataManager;
import com.sparta.AlphaTeam.UserInterface.UserManager;
import com.sparta.AlphaTeam.core.FileEnum;

public class Controller {
    UserManager userManager=new UserManager();
    DataManager dataManager=new DataManager();

    public void collectFileToUse(){
        FileEnum temp =  userManager.getFileENumber();
        String filePath = temp.getFilePath();
        dataManager.setChosenFile(filePath);
    }
    public void getNumberOfThreads(){
        // int threads = userManager.getInputInt();
        int threads = userManager.getUserThread();
    }
    public void convertFileToEmployee(){
        dataManager.convertStringListToEmployee(userManager.readFile(dataManager.getChosenFile().getPath()));
    }

    public void filterRecords(){
        dataManager.sortUnsortedRecords();
    }

    public void displayCleanRecords(){
        System.out.println("clean records___________");
        userManager.displayRecords(dataManager.getCleanRecords());
    }
    public void displayAllDirtyRecords(){
        System.out.println("dirty records___________");
        userManager.displayRecords(dataManager.getAllDirtyRecords());
    }
    public void displayInvalidDateRecords(){
        System.out.println("invalid data___________");
        userManager.displayRecords(dataManager.getInvalidDateRecords());
    }
    public void displayDuplicateRecords(){
        System.out.println("duplicate records___________");
        userManager.displayRecords(dataManager.getDuplicatedRecords());
    }
    public void displayMissingValueRecords(){
        System.out.println("records with missing values___________");
        userManager.displayRecords(dataManager.getCleanRecords());
    }


}
