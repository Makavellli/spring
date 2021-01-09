import java.text.DecimalFormat;
import java.util.Scanner;

public class BodyMassIndex {

    public static void main(String[] args) {

        // 免费计算你的身体质量指数 (BMI)
        System.out.print("欢迎使用身体质量指数 (BMI)计算器！！！！！\n");
        while (true) {
            System.out.print("输入1开始计算,输入2退出程序......\n");
            System.out.print("请输入:\t\t\t\t\t");
            Scanner chooseSC = new Scanner(System.in);
            int chooseNum = chooseSC.nextInt();
            if (chooseNum == 1) {
                System.out.print("请输入身高（单位：CM）:\t\t\t\t\t");
                Scanner heightSc = new Scanner(System.in);
                Double bodyHeight=(heightSc.nextDouble())/100;
                System.out.print("请输入体重（单位：KG）:\t\t\t\t\t");
                Scanner weightSc = new Scanner(System.in);
                Double bodyWeight=weightSc.nextDouble();
                getBMI(bodyHeight, bodyWeight);
            } else if(chooseNum == 2) {
                System.out.print("退出程序！！！！");
                break;
            }else{
                System.out.print("请按套路出牌！！！！");
            }
        }
    }

    /**
     * 计算 BMI
     *
     * @param height
     * @param wight
     */
    public static void getBMI(Double height, Double wight) {
        Double result = wight / (height * height);
        DecimalFormat dc = new DecimalFormat("#.00");
        System.out.println("健康指数为："+dc.format(result)+"\n");
        if (result >= 18.5 && result <= 23.9) {
            System.out.print("完美身材！\t\t\t\t\t\n");
        } else if (result < 18.5 && result > 0) {
            System.out.print("偏瘦！:\t\t\t\t\t\n");
        } else if (result > 23.9) {
            System.out.print("肥胖！:\t\t\t\t\t\n");
        } else {
            System.out.print("外星人勿扰!:\t\t\t\t\t\n");
        }
    }
}
