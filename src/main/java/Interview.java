public class Interview {
    // 1 3 5 7
    // 2 4 6 8
    // 现在的场景放到阿里
    // 带来什么价值

    public static void main(String[] args) {
        int[] arrayA = new int[]{1, 3, 5, 7};
        int[] arrayB = new int[]{2, 4, 6, 8};

        int[] result = merge(arrayA, arrayB);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static int[] merge(int[] a, int[] b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        int[] result = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int index = 0;

        while (i < a.length || j < b.length) {
            if (i == a.length) {
                result[index++] = b[j++];
            } else if (j == b.length) {
                result[index++] = a[i++];
            } else {
                if (a[i] > b[j]) {
                    result[index++] = b[j++];
                } else {
                    result[index++] = a[i++];
                }
            }
        }

        return result;
    }
}
