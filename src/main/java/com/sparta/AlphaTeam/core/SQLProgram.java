package com.sparta.AlphaTeam.core;

import com.sparta.AlphaTeam.Controller.Controller;

public class SQLProgram {

    public void start(){
        Controller controller = new Controller();
        controller.greeting();
        controller.collectFileToUse();
        controller.convertFileToEmployee();
        controller.filterRecords();
        controller.userChoice();
        //controller.displayCleanRecords();
        // TEST INPUT!!!
        controller.getNumberOfThreads();
        controller.generateThreads();

        controller.addToDatabase();

        controller.getRecords();
        controller.displayFetchedRecords();

        //controller.displayAllDirtyRecords();

    }



}
