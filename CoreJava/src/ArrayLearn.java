import java.util.Random;

public class ArrayLearn {


    public static void main(String[] args) {

        //     searchName();
        times();
    }

    public static void test() {
        String str = "111";
        System.out.println(str.indexOf("1"));
    }

    /**
     * 查找某个数字出现多少次
     */

    public static void times() {
        int[] nums = new int[50];
        int times = 0;
        Random rd = new Random();

        for (int i = 0; i < 50; i++) {
            nums[i] = rd.nextInt(49);
        }

        for (int j = 0; j < nums.length; j++) {
            String str = nums[j] + "";
            System.out.println("Current Searching Str Is \t \t \t" + str);
            if (str.indexOf("8") != -1) {
                times++;
            }
        }
        System.out.println("The Length Of Nums Is " + nums.length);
        System.out.println("Arrar Nums Include " + times + "\t\t8");
    }

    /**
     * 查找某个字符串出现在数组的位置
     */
    public static void searchName() {
        String[][] names = {{"lucy", "toms", "suke"}, {"beta", "tom3", "jacky"}, {"andy", "yasun", "tom4"}};
        int times = 0;
        for (int i = 0; i < names.length; i++) {
            String[] names1 = names[i];
            for (int j = 0; j < names1.length; j++) {
                String targetName = names1[j];
                while (targetName == "tom") {
                    System.out.println("Tom's Location Is " + i + "\t\t\trow\t\t\t" + j + "\t\t\tcolumn\t\t\t\t");
                    times++;
                    break;
                }
            }
        }
        if (times == 0) {
            System.out.println("There has nobody name'd Tom !!!");
        } else {
            System.out.println("Somebody name'd Tom appears times is " + times);
        }
    }
}
