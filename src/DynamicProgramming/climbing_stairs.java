package DynamicProgramming;
//70
//������������¥�ݡ���Ҫ n ������ܵ���¥����
//ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
//ע�⣺���� n ��һ����������
//ʾ�� 1��
//���룺 2
//����� 2
//���ͣ� �����ַ�����������¥����
//1.  1 �� + 1 ��
//2.  2 ��

//ʾ�� 2��
//���룺 3
//����� 3
//���ͣ� �����ַ�����������¥����
//1.  1 �� + 1 �� + 1 ��
//2.  1 �� + 2 ��
//3.  2 �� + 1 ��
public class climbing_stairs {
    //f(n)��n��̨�׵�����
    //f(n)=f(n-1)+f(n-2)
    //f(1)=1
    //f(2)=2
    public static void main(String[] args) {
        System.out.println(new climbing_stairs.Solution().climbStairs(44));
    }
    //���ݹ�ᳬʱ
    static class Solution {
        public int climbStairs(int n) {
            return f(n);
        }

        public int f(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            return f(n - 1) + f(n - 2);
        }
    }
}
