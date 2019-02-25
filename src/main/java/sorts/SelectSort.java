package sorts;

public class SelectSort {
    public static void main(String[] args) {
        int[] data = new int[] {123, 2, 1, 5, 234, 56, 1, 1, 2, 9, 2, 3};
        selectSort(data);
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public static void selectSort(int[] data) {
        for(int i = 0; i < data.length; i++) {
            int minIndex = i;
            for(int j = i + 1; j < data.length; j++) {
                if(data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
    }
}
