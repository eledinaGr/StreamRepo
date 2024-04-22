package com.scytalys;

import java.util.concurrent.Callable;

public class Worker implements Runnable{

    private int id;

    public Worker(int id) {
        this.id = id;
    }

    public void doWork(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void run() {
        System.out.println("Worker " + id + " started. ");
        doWork();
        System.out.println("Thread " + id + " has finished working. ");
    }
}
