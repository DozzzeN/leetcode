package VIVO;

import java.util.HashMap;
import java.util.Map;

//�ָ������������� n����Ѱ�Ҳ������С�������� m��m>9����ʹ�� m �ĸ�λ����λ��ʮλ����λ ... ...��֮�˻�����n��������������� -1��
//��������1:
//36
//�������1:
//49
//��������2:
//100
//�������2:
//455
public class product_of_digits02 {
    public static void main(String[] args) {
        System.out.println(new product_of_digits02.Solution().solution(362880));
    }

    public static class Solution {
        /**
         * ����һ��������ֵ������һ������ֵ
         *
         * @param n int���� n>9
         * @return int����
         */
        public int solution(int n) {
            Map<Integer, Integer> factor = new HashMap<>();//n�������ӣ�ע�������Ӳ��ܴ���10
            while (n % 2 == 0) {
                n /= 2;
                if (factor.containsKey(2)) {
                    factor.put(2, factor.get(2) + 1);
                } else {
                    factor.put(2, 1);
                }
                if (n == 1) break;
            }
            while (n % 3 == 0) {
                n /= 3;
                if (factor.containsKey(3)) {
                    factor.put(3, factor.get(3) + 1);
                } else {
                    factor.put(3, 1);
                }
                if (n == 1) break;
            }
            while (n % 5 == 0) {
                n /= 5;
                if (factor.containsKey(5)) {
                    factor.put(5, factor.get(5) + 1);
                } else {
                    factor.put(5, 1);
                }
                if (n == 1) break;
            }
            while (n % 7 == 0) {
                n /= 7;
                if (factor.containsKey(7)) {
                    factor.put(7, factor.get(7) + 1);
                } else {
                    factor.put(7, 1);
                }
                if (n == 1) break;
            }
            if (n > 1) return -1;
            StringBuilder result = new StringBuilder();
            //������ĳ˻�֮��Ϊ����λ���ĸ�����9�ǵ���λ�����ģ�
            int numsOf9 = factor.getOrDefault(3, 0) / 2;
            int numsOf8 = factor.getOrDefault(2, 0) / 3;
            int numsOf7 = factor.getOrDefault(7, 0);
            int numsOf6 = Math.min(factor.getOrDefault(2, 0) - numsOf8 * 3, factor.getOrDefault(3, 0) - numsOf9 * 2);
            int numsOf5 = factor.getOrDefault(5, 0);
            int numsOf4 = (factor.getOrDefault(2, 0) - numsOf8 * 3 - numsOf6) / 2;
            numsOf4 = Math.max(numsOf4, 0);
            int numsOf3 = factor.getOrDefault(3, 0) - numsOf9 * 2 - numsOf6;
            numsOf3 = Math.max(numsOf3, 0);
            int numsOf2 = factor.getOrDefault(2, 0) - numsOf8 * 3 - numsOf6 - numsOf4 * 2;
            numsOf2 = Math.max(numsOf2, 0);
            //̰�ģ��ȰѴ�����ŵ����
            for (int i = 0; i < numsOf9; i++) {
                result.append('9');
            }
            for (int i = 0; i < numsOf8; i++) {
                result.append('8');
            }
            for (int i = 0; i < numsOf7; i++) {
                result.append('7');
            }
            for (int i = 0; i < numsOf6; i++) {
                result.append('6');
            }
            for (int i = 0; i < numsOf5; i++) {
                result.append('5');
            }
            for (int i = 0; i < numsOf4; i++) {
                result.append('4');
            }
            for (int i = 0; i < numsOf3; i++) {
                result.append('3');
            }
            for (int i = 0; i < numsOf2; i++) {
                result.append('2');
            }
            return Integer.parseInt(result.reverse().toString());
        }
    }
}
