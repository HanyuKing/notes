package jvm;

public class ThreadConmunication {
    private static final Object mutex = new Object();
    private static boolean isA = true;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (mutex) {
                        while (!isA) {
                            try {
                                System.out.println("A wait...");
                                mutex.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("A");
                        isA = false;
                        mutex.notify();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (mutex) {
                        System.out.println("B acquired lock...");
                        while (isA) {
                            try {
                                mutex.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("B");
                        isA = true;
                        mutex.notify();
                    }
                }
            }
        }).start();
    }
}
