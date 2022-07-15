package com.sparta.AlphaTeam.Controller;

import com.sparta.AlphaTeam.DataManagement.DataManager;
import com.sparta.AlphaTeam.UserInterface.UserManager;
import com.sparta.AlphaTeam.core.FileEnum;

public class Controller {
    UserManager userManager=new UserManager();
    DataManager dataManager=new DataManager();

    public void greeting(){
        userManager.intro();
    }
    public boolean userChoice(){

        switch (userManager.userChoicePanel()){
            case 1: if (dataManager.getCleanRecords().size()==0 || dataManager.getCleanRecords()==null){
                System.out.println("sorry, there are no clean records right now.");
            }

            case 2:

            case 3:

            case 4:

            case 5:

            case 6:

            case 7:

            case 8:

            case 9:

            case 10:

            case 11:

            case 12:
        }
        return true;
    }

    public void collectFileToUse(){
        FileEnum temp =  userManager.getFileENumber();
        String filePath = temp.getFilePath();
        dataManager.setChosenFile(filePath);
    }
    public void getNumberOfThreads(){
        int threads = userManager.getUserThread();
        dataManager.setThreadCount(threads);
    }
    public void generateThreads(){
        dataManager.createThreads();
    }
    public void addToDatabase(){
        dataManager.addAllToDatabase();
    }

    public void convertFileToEmployee(){
        dataManager.convertStringListToEmployee(userManager.readFile(dataManager.getChosenFile().getPath()));
    }

    public void filterRecords(){
        dataManager.sortUnsortedRecords();
    }
    public void getRecords(){
        dataManager.getEmployeeFromDatabase();
    }


    public void displayFetchedRecords(){
        System.out.println("records from database___________");
        userManager.displayRecords(dataManager.getFetchedRecords());
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
