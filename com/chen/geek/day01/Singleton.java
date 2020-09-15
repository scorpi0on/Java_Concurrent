package com.chen.geek.day01;

public class Singleton {

    static Singleton singleton;

    static int count = 0;

    static Singleton getInstance() throws InterruptedException {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                    System.out.println("new a singleton and wait 5s...");
                    Thread.sleep(5000);
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                Singleton.getInstance();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                Singleton.getInstance();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }

}
