package jvm;

public class StackOverFlow {
    public static void main(String[] args) {
        new StackOverFlow().fun();
    }

    public void fun() {
        while (true) {
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        System.out.println(Thread.currentThread().getId());
                    }
                }
            }).start();
        }
    }
}
