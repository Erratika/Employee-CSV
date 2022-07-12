package com.sparta.AlphaTeam.Reader;

import com.sparta.AlphaTeam.DataManager;

public class Controller {
    UserManager userManager=new UserManager();
    DataManager dataManager=new DataManager();

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
