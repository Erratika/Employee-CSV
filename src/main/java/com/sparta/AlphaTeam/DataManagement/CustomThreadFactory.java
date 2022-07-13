package com.sparta.AlphaTeam.DataManagement;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {
    int threadCount;

    public int getThreadCount() {
        return threadCount;
    }

    @Override
    public Thread newThread(Runnable r) {

        threadCount++;
        return new Thread(r);
    }
}
