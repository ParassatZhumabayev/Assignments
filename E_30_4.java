package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MutableInteger {
    private int i;
    public MutableInteger() {
        this(0);
    }

    public MutableInteger(int i) {
        this.i= i;
    }

    public int inc() {
        return ++i;
    }
    public synchronized int syncInc() {
        return ++i;
    }
}


public class E_30_4{
    private static int thread;

    public static void main(String[] args){
        ExecutorService exec = Executors.newFixedThreadPool(1000);
        for ( thread = 0; thread <= 1000; thread++) {
            exec.execute(new Sum());
        }

        exec.shutdown();
        try {
            boolean b = exec.awaitTermination(50, TimeUnit.SECONDS);
            System.out.println("End: " + b);
        } catch (InterruptedException e) { e.printStackTrace(); }}
}

class Sum extends Thread {
    private MutableInteger sum = new MutableInteger();

    public void run() {
        System.out.println("at " + Thread.currentThread()+"sum is "+sum.syncInc());
    }
}

