package VIVO;

//在vivo产线上，每位职工随着对手机加工流程认识的熟悉和经验的增加，日产量也会不断攀升。
//假设第一天量产1台，接下来2天(即第二、三天)每天量产2件，接下来3天(即第四、五、六天)每天量产3件 ... ...
//以此类推，请编程计算出第n天总共可以量产的手机数量。
//输入例子1:
//11
//输出例子1:
//35
//例子说明1:
//第11天工人总共可以量产的手机数量
public class vivo_smartphone_production_capacity {
    public static void main(String[] args) {
        System.out.println(new vivo_smartphone_production_capacity.Solution().solution(11));
    }

    public static class Solution {
        /**
         * @param n int整型 第n天
         * @return int整型
         */
        public int solution(int n) {
            int x = 1, sum = 1, result = 0;
            //算出n的下一个等差数列和，x是最后一个数：11处于10（1加到4）和15（1加到5）之间
            while (sum <= n) {
                sum = x * (1 + x) / 2;
                x++;
            }
            x--;//抵消while循环中最后一次自增
            //求出1到n的上一个等差数列最后一个数的和：1+2+2+3+3+3+4+4+4+4
            for (int i = 1; i < x; i++) {
                result += (i * i);
            }
            //剩下的：+5
            for (int i = (x - 1) * x / 2; i < n; i++) {
                result += x;
            }
            return result;
        }
    }
}
