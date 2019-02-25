package sorts;

public class BubboSort {
    public static void main(String[] args) {
        int[] data = new int[] {123, 2, 1, 5, 234, 56, 1, 1, 2, 9, 2, 3};
        bubboSort(data);
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public static void bubboSort(int[] data) {
        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data.length - i - 1; j++) {
                if(data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}
