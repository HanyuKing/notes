package sorts;

import java.util.Stack;

public class QuickSort {
    public static void main(String[] args) {
        int[] data = new int[] {123, 2, 1, 5, 234, 56, 1, 1, 2, 9, 2, 3};
        quickSort(data, 0, data.length - 1);
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public static void quickSort3(int[] data, int left, int right) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(right);
        stack.push(left);

        while (!stack.isEmpty()) {
            left = stack.pop();
            right = stack.pop();

            int p = partition(data, left, right);
            if(left < p) {
                stack.push(p - 1);
                stack.push(left);
            }
            if(p < right) {
                stack.push(right);
                stack.push(p + 1);
            }

        }
    }

    public static void quickSort2(int[] data, int left, int right) {
        if(left >= right) return;
        int p = partition(data, left, right);
        quickSort2(data, left, p - 1);
        quickSort2(data, p + 1, right);
    }

    public static int partition(int[] data, int left, int right) {
        int base = data[left];
        while (left < right) {
            while (left < right && data[right] > base) right--;
            data[left++] = data[right];
            while (left < right && data[left] < base) left++;
            data[right--] = data[left];
        }
        data[left] = base;
        return left;
    }

    public static void quickSort(int[] data, int left, int right) {
        int i = left;
        int j = right;
        int base = data[left];
        while (i < j) {
            while (i < j && data[j] > base) --j;
            data[i] = data[j];
            ++i;
            while (i < j && data[i] < base) ++i;
            data[j] = data[i];
        }
        data[i] = base;
        if(left < i)
            quickSort(data, left, i - 1);
        if(i + 1 < right)
            quickSort(data, i + 1, right);
    }
}
