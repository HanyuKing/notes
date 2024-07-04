import java.util.HashMap;
import java.util.Map;

public class LoopCost {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(1);
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //t.setDaemon(true);
        t.start();
    }
}
