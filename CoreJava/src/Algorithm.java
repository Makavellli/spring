import java.util.Random;
import java.util.Scanner;

public class Algorithm {
    public static void main(String[] args) {
        //    getMax();
        //    reverseArrary();
        //    maintanceArrary();
        //    addArrary();
        ifEquals();
    }

    /**
     * 查找数组中最大的数
     */
    public static void getMax() {
        int[] nums = new int[50];
        int times = 0;
        Random rd = new Random();

        for (int i = 0; i < 50; i++) {
            nums[i] = rd.nextInt(1000);
        }
        System.out.println("数组nums的长度为:" + nums.length);
        /**
         * 开始查找
         */
        int max = 1;
        for (int j = 0; j < nums.length; j++) {
            System.out.println("开始查找最大数。。。。。。");
            System.out.println("第" + (j + 1) + "个数值为：" + nums[j]);
            if (nums[j] > max) {
                max = nums[j];
            }
        }
        System.out.println("最大值为：" + max);
    }

    /**
     * 反转数组
     * 其他方法待展开  如只循环到数组长度的一半  该如何实现
     */
    public static void reverseArrary() {
        String[] str = {"abc", "def", "ghi", "jkl", "lmn", "opq", "rst"};
        String[] str1 = new String[7];
        for (int i = 0; i < str.length; i++) {
            str1[str.length - 1 - i] = str[i];
        }
        for (int j = 0; j < str1.length; j++) {
            System.out.println("打印新数组的第" + (j + 1) + "个元素，值为：" + str1[j]);
        }
    }

    /**
     * 修改数组 删除
     */
    public static void deleteArrary() {
        String[] str = {"abc", "def", "ghi", "jkl", "lmn", "opq", "rst"};
        Scanner sc = new Scanner(System.in);
        for (int j = 0; j < str.length; j++) {
            System.out.println("数组的第" + (j + 1) + "个元素，值为：" + str[j]);
        }
        System.out.println("请输入想要删除元素的序号，请输入。。。。。。。。。\n");
        int number = sc.nextInt();
        String[] str1 = new String[str.length - 1];
        for (int i = 0; i < str.length; i++) {
            if (i == number - 1) {
                System.out.println("删除元素为:\t" + str[i]);
            } else if (i >= number) {
                str1[i - 1] = str[i];
            } else {
                str1[i] = str[i];
            }
        }
        for (int j = 0; j < str1.length; j++) {
            System.out.println("打印新数组的第" + (j + 1) + "个元素，值为：" + str1[j]);
        }
    }

    /**
     * 修改数组 增加
     */
    public static void addArrary() {
        String[] str = {"abc", "def", "ghi", "jkl", "lmn", "opq", "rst"};
        Scanner sc = new Scanner(System.in);
        for (int j = 0; j < str.length; j++) {
            System.out.println("数组的第" + (j + 1) + "个元素，值为：" + str[j]);
        }
        System.out.println("请输入想要增加元素的序号，请输入。。。。。。。。。\n");
        int number = sc.nextInt();
        Scanner scStr = new Scanner(System.in);
        System.out.println("请输入想要增加的元素内容，请输入。。。。。。。。。\n");
        String inputStr = scStr.nextLine();

        String[] str1 = new String[str.length + 1];
        for (int i = 0; i < str.length + 1; i++) {
            if (i == number - 1) {
                System.out.println("增加元素为:\t" + inputStr);
                str1[i] = inputStr;
            } else if (i >= number) {
                str1[i] = str[i - 1];
            } else {
                str1[i] = str[i];
            }
        }
        for (int j = 0; j < str1.length; j++) {
            System.out.println("打印新数组的第" + (j + 1) + "个元素，值为：" + str1[j]);
        }
    }

    /**
     * 修改数组 增加
     */
    public static void ifEquals() {
        String[] str = {"abc", "def", "ghi", "jkl", "lmn", "opq", "rst"};
        String[] str1 = {"abc", "def", "ghi", "jkl1", "lmn", "opq", "rst"};
        int number = 0;
        if (str.length == str1.length) {
            for (int i = 0; i < str.length; i++) {
                if (str[i] == str1[i]) {
                    number++;
                    if (number == str.length) {
                        System.out.println("两个数组为相同的数组！！！");
                    }
                } else {
                    System.out.println("第" + i + "个元素不一致,为两个不同的数组;" + "他们分别是：" + str[i] + "\t\t" + str1[i]);
                    break;
                }
            }
        } else {
            System.out.println("数组长度不一致,为两个不同的数组！！！");
        }
    }
}
