package jvm.gcdemo;

/**
 * Example1: -Xms20M –Xmx20M –Xmn10M –XX:+UseSerialGC -XX:+PrintGCDetails
 * Example2: -Xms20M –Xmx20M –Xmn10M -XX:-HandlePromotionFailure –XX:+UseSerialGC -XX:+PrintGCDetails
 */
public class SerialGCDemo {
    public static void main(String[] args) throws Exception {
        byte[] bytes=new byte[1024*1024*2];
        byte[] bytes2=new byte[1024*1024*2];
        byte[] bytes3=new byte[1024*1024*2];
        System.out.println("step 1");
        bytes=null;
        byte[] bytes4=new byte[1024*1024*2];
        Thread.sleep(3000);
        System.out.println("step 2");
        byte[] bytes5=new byte[1024*1024*2];
        byte[] bytes6=new byte[1024*1024*2];
        bytes4=null;
        bytes5=null;
        bytes6=null;
        System.out.println("step 3");
        byte[] bytes7=new byte[1024*1024*2];
        Thread.sleep(3000);
    }
}