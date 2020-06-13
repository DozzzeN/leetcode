package NumberTheory;

import java.util.Arrays;

//求整数x，y使得ax+by=d，a和b的最大公约数是d
public class 扩展欧几里得算法 {

    public static void main(String[] args) {
        //3*30-2*42=6
        System.out.println(Arrays.toString(new 扩展欧几里得算法().extgcd(30, 42)));
    }

    public int[] extgcd(int a, int b) {
        int d;
        int[] res = new int[3];
        if (b != 0) {
            int[] temp = extgcd(b, a % b);
            d = temp[0];
            res[0] = d;
            res[1] = temp[2];
            res[2] = temp[1] - (a / b) * temp[2];
        } else {
            res[0] = a;
            res[1] = 1;
            res[2] = 0;
        }
        return res;
    }
}
