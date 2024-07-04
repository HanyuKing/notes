import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * https://zhuanlan.zhihu.com/p/74769428
 *
 * 线程池打印错误
 *
 *
 * 1。future
 * 2。setUncaughtExceptionHandler
 * 3。自定义线程池 before after
 * 4。
 */

class MyThreadPool extends ThreadPoolExecutor {

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        if (t != null) {
            t.printStackTrace();
        }
    }
}

public class ThreadPoolTest {
    public static void main(String[] args) {
        /**
         * 3。自定义线程池 before after
         */
//        MyThreadPool pool = new MyThreadPool(5, 10, 1, TimeUnit.MINUTES,
//                new LinkedBlockingQueue<>(100));
//        CountDownLatch latch = new CountDownLatch(10);
//        for(int i = 0; i < 10; i++) {
//            final int j = i;
//            pool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        if (j == 7) {
//                            throw new RuntimeException("hhhh");
//                        }
//                        System.out.println(j);
//                    } finally {
//                        latch.countDown();
//                    }
//                }
//            });
//
//        }
//        try {
//            latch.await();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("end");
        /**
         *  * 1。future
         */
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 1, TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(100));

        List<Future<Integer>> list = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            final int j = i;
            list.add(pool.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(1000);
                    if (j == 7) {
                        throw new RuntimeException("hhhh");
                    }
                    return j;
                }
            }));
        }
        for (Future<Integer> f: list) {
            try {
                System.out.println(f.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /**
         *  * 2。setUncaughtExceptionHandler
         */
//        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 1, TimeUnit.MINUTES,
//                new LinkedBlockingQueue<>(100), new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                ThreadFactory factory = Executors.defaultThreadFactory();
//                Thread t = factory.newThread(r);
//                t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//                    @Override
//                    public void uncaughtException(Thread t, Throwable e) {
//                        e.printStackTrace();
//                    }
//                });
//                return t;
//            }
//        });
//
//        CountDownLatch latch = new CountDownLatch(10);
//
//        for(int i = 0; i < 10; i++) {
//            final int j = i;
//            pool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        if (j == 7) {
//                            throw new RuntimeException("hhhh");
//                        }
//                        System.out.println(j);
//                    } finally {
//                        latch.countDown();
//                    }
//                }
//            });
//
//        }
//        try {
//            latch.await();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("end");
    }
}
