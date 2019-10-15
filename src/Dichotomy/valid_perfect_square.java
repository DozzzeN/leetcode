package Dichotomy;

//367
//����һ�������� num����дһ����������� num ��һ����ȫƽ�������򷵻� True�����򷵻� False��
//˵������Ҫʹ���κ����õĿ⺯������  sqrt��
//ʾ�� 1��
//���룺16
//�����True
//ʾ�� 2��
//���룺14
//�����False
public class valid_perfect_square {
    public static void main(String[] args) {
        System.out.println(new valid_perfect_square.Solution().isPerfectSquare(808201));
    }

    //ע���ֹtemp���
    static class Solution {
        public boolean isPerfectSquare(int num) {
            long left = 0, right = num;
            while (left < right) {
                long mid = (left + right) >>> 1;
                long temp = mid * mid;
                if (temp == num) return true;
                else if (temp > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left * left == num;
        }
    }
}
