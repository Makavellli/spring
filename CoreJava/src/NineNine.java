
public class NineNine {
    /**
     * 打印 9*9 乘法表
     * @param args
     */
    public static void main(String[] args) {
        int[] numX = {1,2,3,4,5,6,7,8,9};
        int[] numY = {1,2,3,4,5,6,7,8,9};
        for(int i=0;i<numX.length;i++){
            for(int j=0;j<numY.length;j++){
                System.out.print(numY[j]+"*"+numX[i]+"="+(numX[i]*numY[j])+"\t");
                if(i==j){
                    System.out.print("\n");
                    break;
                }
            }
        }
    }
}
