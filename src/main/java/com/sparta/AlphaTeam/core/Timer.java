package com.sparta.AlphaTeam.core;

public class Timer {
	double start;

	public void start(){
		start = System.nanoTime();
	}
	public double stop(){
		return System.nanoTime() - start;
	}
}
