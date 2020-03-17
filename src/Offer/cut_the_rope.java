package Offer;

//https://www.nowcoder.com/practice/57d85990ba5b440ab888fc72b0751bf8?tpId=13&tqId=33257&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//����һ������Ϊn�����ӣ�������Ӽ�����������m�Σ�m��n����������n>1����m>1����
//ÿ�����ӵĳ��ȼ�Ϊk[0],k[1],...,k[m]������k[0]xk[1]x...xk[m]���ܵ����˻��Ƕ��٣�
//���磬�����ӵĳ�����8ʱ�����ǰ������ɳ��ȷֱ�Ϊ2��3��3�����Σ���ʱ�õ������˻���18��
public class cut_the_rope {
    public static void main(String[] args) {
        System.out.println(new cut_the_rope.Solution().cutRope(8));
        System.out.println(new cut_the_rope.Solution().cutRope2(30));
        System.out.println(new cut_the_rope.Solution().cutRope3(30));
    }

    public static class Solution {
        private int max = 1;

        //��ͨ�ݹ飺�ٶ�̫��
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

        //̰�ģ������ֳܷ�3��Ȼ���ٷֳ�2������4������Ҫ�ֳ�2*2
        public int cutRope2(int target) {
            if (target < 2) return 0;
            if (target == 2) return 1;
            if (target == 3) return 2;
            int countsOf3 = target / 3;
            countsOf3 = target - 3 * countsOf3 == 1 ? countsOf3 - 1 : countsOf3;
            int countsOf2 = (target - 3 * countsOf3) / 2;
            return (int) (Math.pow(3, countsOf3) * Math.pow(2, countsOf2));
        }

        //��̬�滮���Ż��ݹ�ķ���
        //f(n) = max{ f(0)*f(n), f(1)*f(n-1), ..., f(n/2)*f(n - n/2) }
        //f(5) = max{ f(0)*f(5), f(1)*f(4), ..., f(2)*f(3) }
        //����f(n)��ʱ����ظ��õ�f(n-1),f(n-2),...
        public int cutRope3(int target) {
            if (target < 2) return 0;
            if (target == 2) return 1;
            if (target == 3) return 2;
            int[] f = new int[target + 1];
            //��ʼ��
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
