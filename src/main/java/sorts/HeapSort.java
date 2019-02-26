package sorts;

public class HeapSort {
    public static void main(String[] args) {
        int[] data = new int[] {123, 2, 1, 5, 234, 56, 1, 1, 2, 9, 2, 3};
        heapSort(data);
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public static void heapSort(int[] data) {
        for(int i = data.length / 2 - 1; i >= 0; i--) {
            adjustHeap(data, i, data.length - i);
        }

        for(int i = 0; i < data.length; i++) {
            int temp = data[0];
            data[0] = data[data.length - i - 1];
            data[data.length - i - 1] = temp;
            adjustHeap(data, 0, data.length - i - 1);
        }
    }

    public static void adjustHeap(int[] data, int index, int length) {
        int temp = data[index];

        for(int i = index * 2 + 1; i < length; i = 2 * index + 1) {
            int biggerIndex = i;
            if(i + 1 < length && data[i] < data[i + 1]) {
                biggerIndex = i + 1;
            }
            if(data[biggerIndex] > temp) {
                data[index] = data[biggerIndex];
                index = biggerIndex;
            } else {
                break;
            }
        }

        data[index] = temp;
    }
}
