public class AddNum {

    /**

     提示：
     num1 和num2 的长度都小于 5100
     num1 和num2 都只包含数字 0-9
     num1 和num2 都不包含任何前导零

     示例：
     num1: "234"
     num2: "123"
     output: "357"

     */
    /**
     *
     * "887"
     * "123"
     * 1010
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(addNum("887", "123"));
    }

    public static String addNum(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int index1 = str1.length() - 1;
        int index2 = str2.length() - 1;

        int carry = 0;

        StringBuilder result = new StringBuilder();

        while (index1 >= 0 || index2 >= 0) {
            if (index1 >= 0 && index2 >= 0) {
                int sum = chars1[index1--] - '0' + chars2[index2--] - '0' + carry;

                result.append(sum % 10);

                carry = sum / 10;

            } else if (index1 >= 0 && index2 < 0) {
                int sum = chars1[index1--] - '0' + carry;
                result.append(sum % 10);
                carry = sum / 10;
            } else if (index1 < 0 && index2 >= 0) {
                int sum = chars2[index2--] - '0' + carry;
                result.append(sum % 10);
                carry = sum / 10;
            }
        }
        if (carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
