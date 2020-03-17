package Offer;

//https://www.nowcoder.com/practice/57d85990ba5b440ab888fc72b0751bf8?tpId=13&tqId=33257&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
//每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
//例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
public class cut_the_rope {
    public static void main(String[] args) {
        System.out.println(new cut_the_rope.Solution().cutRope(8));
        System.out.println(new cut_the_rope.Solution().cutRope2(30));
        System.out.println(new cut_the_rope.Solution().cutRope3(30));
    }

    public static class Solution {
        private int max = 1;

        //普通递归：速度太慢
        public int cutRope(int target) {
            count(target, 1, 0);
            return max;
        }

        private void count(int target, int result, int current) {
            if (target == current) {
                max = Math.max(max, result);
            } else {
                for (int i = 1; i < target; i++) {
                    if (current + i <= target) {
                        count(target, result * i, current + i);
                    }
                }
            }
        }

        //贪心：尽可能分成3，然后再分成2，但是4这种需要分成2*2
        public int cutRope2(int target) {
            if (target < 2) return 0;
            if (target == 2) return 1;
            if (target == 3) return 2;
            int countsOf3 = target / 3;
            countsOf3 = target - 3 * countsOf3 == 1 ? countsOf3 - 1 : countsOf3;
            int countsOf2 = (target - 3 * countsOf3) / 2;
            return (int) (Math.pow(3, countsOf3) * Math.pow(2, countsOf2));
        }

        //动态规划：优化递归的方法
        //f(n) = max{ f(0)*f(n), f(1)*f(n-1), ..., f(n/2)*f(n - n/2) }
        //f(5) = max{ f(0)*f(5), f(1)*f(4), ..., f(2)*f(3) }
        //计算f(n)的时候会重复用到f(n-1),f(n-2),...
        public int cutRope3(int target) {
            if (target < 2) return 0;
            if (target == 2) return 1;
            if (target == 3) return 2;
            int[] f = new int[target + 1];
            //初始化
            for (int i = 0; i < 4; i++) {
                f[i] = i;
            }
            for (int i = 4; i < target + 1; i++) {
                int max = 0;
                for (int j = 0; j < i / 2 + 1; j++) {
                    max = Math.max(max, f[j] * f[i - j]);
                }
                f[i] = max;
            }
            return f[target];
        }
    }
}
