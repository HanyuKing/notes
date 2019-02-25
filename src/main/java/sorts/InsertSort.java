package sorts;

public class InsertSort {
    public static void main(String[] args) {
        int[] data = new int[] {123, 2, 1, 5, 234, 56, 1, 1, 2, 9, 2, 3};
        insertSort(data);
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public static void insertSort(int[] data) {
        for(int i = 1; i < data.length; i++) {
            int temp = data[i];
            int j = i - 1;
            for(; j >= 0; j--) {
                if(temp < data[j]) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = temp;
        }
    }
}
