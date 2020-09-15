package com.chen.geek.day02;

class VolatileExample {
    int x = 0;
    volatile boolean v = false;
    public void writer() {
        x = 42;
        v = true;
    }
    public void reader() {
        if (v == true) {
            // 这里 x 会是多少呢？
            System.out.println(x);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileExample volatileExample = new VolatileExample();
        Thread th1 = new Thread(()->{volatileExample.writer();});
        Thread th2 = new Thread(()->{volatileExample.reader();});
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
    }
}