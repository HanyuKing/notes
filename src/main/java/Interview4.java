public class Interview4 {
    /**
     * 求一个数值的整数次方
     *
     * @param args
     */
    private static double NUM = 0.0000000000000001;
    public static void main(String[] args) {
        System.out.println(numPower(2, 4));
        System.out.println(numPower(2, -4));
        System.out.println(numPower(5, -5));
        System.out.println(numPower(2, 5));
        System.out.println(numPower(2, 9));
        System.out.println(numPower(5, 1));
    }

    /**
     *  5
     *  2 * (2 * 2) * (2 * 2)
     *
     * @param num
     * @param power
     * @return
     */
    public static double numPower(double num, int power) {
        if (power == 0) return 1;

        if (Math.abs(num - 0) < NUM) return 0;

        if (power < 0) {
            num = 1 / num;
            power = -power;
        }

        double result = num;
        for (int i = 2; i <= power; i = i * 2) {
            result = result * result;
        }

        if (Math.abs(power) != 1 && power % 2 == 1) {
            result = result * num;
        }
        return result;
    }
    /**
     *
     * 每一条帖子的最新评论
     *
     * tiezi (
     *  id 主键
     *  name
     *  create_time
     *  update_time
     * )
     *
     * comment (
     *  id 主键 自增
     *  tiezi_id
     *  content  text
     *  create_time
     *  update_time
     * )
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * select content from comment where tiezi_id = '1111' order by id desc limit 1;
     */
}