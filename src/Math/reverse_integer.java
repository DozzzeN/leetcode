package Math;

//7
//����һ�� 32 λ���з�������������Ҫ�����������ÿλ�ϵ����ֽ��з�ת��
//ʾ�� 1:
//����: 123
//���: 321
// ʾ�� 2:
//����: -123
//���: -321
//ʾ�� 3:
//����: 120
public class reverse_integer {
    //ע�����
    static class Solution {
        public int reverse(int x) {
            double y = 0;
            int z = Math.abs(x);
            int weishu = 0;
            while (z > 0) {
                weishu++;
                z /= 10;
            }
            z = Math.abs(x);
            for (int i = weishu; i > 0; i--) {
                y += (z % 10) * Math.pow(10, i - 1);
                if (y < Integer.MIN_VALUE || y > Integer.MAX_VALUE) {
                    return 0;
                }
                z /= 10;
            }
            return x > 0 ? (int) y : -(int) y;
        }
    }

    public static void main(String[] args) {
        reverse_integer.Solution sol = new reverse_integer.Solution();
        System.out.println(sol.reverse(153436469));//1534236469
    }
}
