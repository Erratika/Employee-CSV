package com.sparta.AlphaTeam.core;

public class Timer {
	long start;

	public void start(){
		start = System.nanoTime();
	}
	public long stop(){
		return System.nanoTime() - start;
	}
}
