package jvm.gcdemo;

/**
 * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+UseParallelGC -XX:+PrintGCDetails
 */
public class PSGCDemo {
    public static void main(String[] args) throws Exception {
        byte[] bytes=new byte[1024*1024*2];
        byte[] bytes2=new byte[1024*1024*2];
        byte[] bytes3=new byte[1024*1024*2];
        System.out.println("step 1");
        byte[] bytes4=new byte[1024*1024*2];
        Thread.sleep(3000);
        System.out.println("step 2");
        byte[] bytes5=new byte[1024*1024*2];
        byte[] bytes6=new byte[1024*1024*2];
        System.out.println("step 3");
        byte[] bytes7=new byte[1024*1024*2];
        Thread.sleep(3000);
    }
}