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
        dataManager.sortData();
    }

    public void displayCleanRecords(){
        userManager.displayRecords(dataManager.getCleanRecords());
    }
    public void displayAllDirtyRecords(){
        userManager.displayRecords(dataManager.getAllDirtyRecords());
    }
    public void displayInvalidDateRecords(){
        userManager.displayRecords(dataManager.getInvalidDateRecords());
    }
    public void displayDuplicateRecords(){
        userManager.displayRecords(dataManager.getDuplicatedRecords());
    }
    public void displayMissingValueRecords(){
        userManager.displayRecords(dataManager.getCleanRecords());
    }


}
