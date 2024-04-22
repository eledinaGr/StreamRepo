package com.scytalys;

public class Main {
    public static void main(String[] args) {

        Worker workerOne = new Worker(1);
        Worker workerTwo = new Worker(2);

        long startingTime = System.currentTimeMillis();
        Thread threadOne = new Thread(workerOne);
        Thread threadTwo = new Thread(workerTwo);
        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endingTime = System.currentTimeMillis();
        System.out.println("time: " + (endingTime-startingTime) + " millisecond");

    }
}