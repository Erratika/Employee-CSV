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

	public void customThreadFactory(int threadCount, List<Employee> employeeList) {
		Thread[] threadArray = new Thread[threadCount];
		int remainder = employeeList.toArray().length % threadCount;
		int innerArraysSize = employeeList.toArray().length / threadCount;

		Employee[][] employeeNestedArray = new Employee[threadCount][innerArraysSize];

//		employeeList.toArray();
		int k = 0;
		for (int i = 0; i < threadCount; i++) {
			for (int j = 0; j < innerArraysSize; j++){
				employeeNestedArray[i][j] = employeeList.get(k);
				k++;
			}
		}
		Employee[] remainderArray = new Employee[employeeNestedArray[0].length + remainder];
		for (int i=0 ; i<employeeNestedArray[0].length ; i++){
			remainderArray[i] = employeeNestedArray[0][i];
		}
		while (remainder>0){
			remainderArray[remainderArray.length-1-remainder] = employeeList.get(employeeList.size()-remainder) ;
			remainder--;
		}
//
	}


}

