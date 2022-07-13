package com.sparta.AlphaTeam.DataManagement;

import java.util.List;
import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {
//    int threadCount;
//
//    public int getThreadCount() {
//        return threadCount;
//    }

    @Override
    public Thread newThread(Runnable r) {

//        threadCount++;
        return new Thread(r);
    }
    public void customThreadFactory(int threadCount, List<Employee> employeeList){
        Thread[] threadArray = new Thread[threadCount];
        Employee[][] powerRangers = new Employee[threadCount][];


    }
}
