package jvm.bluedavy.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class DirectMemoryOOM {

    // Cached unsafe-access object
    private static Unsafe unsafe;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe"); // Internal reference
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void main(String[] args) {
        List<ByteBuffer> buffers = new ArrayList<ByteBuffer>(100);

        List<Long> longs = new ArrayList<Long>(100);

        for(int i = 0; i < 100; i++) {
            //buffers.add(ByteBuffer.allocateDirect(4 * 1024 * 1024));  // jdk throw an Exception

            //longs.add(unsafe.allocateMemory(400 * 1024 * 1024)); // jvm throw exception
        }

        System.gc();
    }
}
