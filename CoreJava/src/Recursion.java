public class Recursion {
    public static void main(String[] args) {
        for (int i = 1; i <= 11; i++) {
            System.out.println("M1+++++青蛙跳过"+i+"个阶梯，有"+fogUpStairs(i)+"种跳法！");
            System.out.println("M2+++++青蛙跳过"+i+"个阶梯，有"+fogUpStairsUp(i)+"种跳法！");
        }
    }

    /**
     * 阶层计算
     *
     * @param number
     * @return
     */
    public static long caculater(int number) {
        if (number == 1) {
            return 1;
        } else {
            return number * caculater(number - 1);
        }
    }

    /**
     * 菲波那切数列
     * 1 1 2 3 5 8 13 21 34 .....
     */

    public static int fib(int number) {
        if (number == 1) return 1;
        if (number == 2) return 1;
        return fib(number - 1) + fib(number - 2);
    }

    /**
     * 青蛙 一次可以跳跃1个或者2个台阶 计算出跳上n个台阶有多少种跳法
     * 分析：
     *  f(1) = 1
     *  f(2) = 2
     *  f(n) = f(n-1) + f(n-2)
     */
    public static int fogUpStairs(int stairsNums) {
        if (stairsNums == 0 | stairsNums == 1 | stairsNums == 2) return stairsNums;
        if (stairsNums >= 3) return fogUpStairs(stairsNums - 1) + fogUpStairs(stairsNums - 2);
        return stairsNums;
    }
    /**
     * 青蛙 一次可以跳跃1、2、3、4....个台阶 计算出跳上n个台阶有多少种跳法
     * 分析：
     * 式1：
     * f(n) = f(n-1) + f(n-2) + ... + f(2) + f(1)
     * 式2：
     * f(n-1) = f(n-2) + f(n-3) + ... + f(2) + f(1)
     * 将式1中的f(n-2) + f(n-3) + … + f(2) + f(1) 替换成式2，可知：、
     * f(n) = f(n-1) + f(n-1) = 2 * f(n-1)
     */
    public static int fogUpStairsUp(int stairsNums) {
        if (stairsNums == 0 | stairsNums == 1 | stairsNums == 2) return stairsNums;
        if (stairsNums >= 3) return 2*fogUpStairs(stairsNums - 1) ;
        return stairsNums;
    }
}