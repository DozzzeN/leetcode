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
public class climbing_stairs02 {
    //f(n)��n��̨�׵�����
    //f(n)=f(n-1)+f(n-2)
    //f(1)=1
    //f(2)=2
    public static void main(String[] args) {
        System.out.println(new climbing_stairs02.Solution().climbStairs(10));
    }

    static class Solution {
        //�ӵ��Ʊ��˳�ơ�����ο��ٷ����Ķ��ַ���
        public int climbStairs(int n) {
            int fn_1 = 2, fn_2 = 1;
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int fn = 0;
            //����쳲��������У�1 2 3 5 8 13 21
            for (int i = 3; i <= n; i++) {
                //f(n)=f(n-1)+f(n-2)
                fn = fn_2 + fn_1;
                fn_2 = fn_1;//��ֵΪ��һ��ֵ
                fn_1 = fn;//��ֵΪ��һ��ֵ
            }
            return fn;
        }

    }
}
