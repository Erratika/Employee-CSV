package com.sparta.AlphaTeam.core;

import com.sparta.AlphaTeam.Controller.Controller;

public class SQLProgram {

    public void start(){
        Controller controller = new Controller();

        controller.collectFileToUse();
        controller.convertFileToEmployee();
        controller.filterRecords();
        //controller.displayCleanRecords();
        //controller.displayAllDirtyRecords();
        controller.getNumberOfThreads();
    }



}
