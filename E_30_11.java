package com.company;

public class E_30_11 {
    public static void main(String[] args) {
        final String s1 = "cat";
        final String s2 = "dog";
        Thread t1 = new Thread() {
            public void run() {
                synchronized (s1) {
                    System.out.println("thread1 locked s1");

                    try { Thread.sleep(100);} catch (Exception e) {}

                    synchronized (s2) {
                        System.out.println("thread1 locked s2");
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                synchronized (s2) {
                    System.out.println("thread2 locked s2");

                    try { Thread.sleep(100);} catch (Exception e) {}

                    synchronized (s1) {
                        System.out.println("thread2 locked s1");
                    }
                }
            }
        };


        t1.start();
        t2.start();
    }
}

