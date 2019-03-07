package jvm;

import java.util.ArrayList;
import java.util.List;

public class ArraySizeLimit {
    public static void main(String[] args) {
        //int[] a = new int[Integer.MAX_VALUE - 1];
        List<Integer> list = new ArrayList<Integer>(Integer.MAX_VALUE - 1000);

    }
}
