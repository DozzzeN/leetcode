package VIVO;

//��vivo�����ϣ�ÿλְ�����Ŷ��ֻ��ӹ�������ʶ����Ϥ�;�������ӣ��ղ���Ҳ�᲻��������
//�����һ������1̨��������2��(���ڶ�������)ÿ������2����������3��(�����ġ��塢����)ÿ������3�� ... ...
//�Դ����ƣ����̼������n���ܹ������������ֻ�������
//��������1:
//11
//�������1:
//35
//����˵��1:
//��11�칤���ܹ������������ֻ�����
public class vivo_smartphone_production_capacity {
    public static void main(String[] args) {
        System.out.println(new vivo_smartphone_production_capacity.Solution().solution(11));
    }

    public static class Solution {
        /**
         * @param n int���� ��n��
         * @return int����
         */
        public int solution(int n) {
            int x = 1, sum = 1, result = 0;
            //���n����һ���Ȳ����кͣ�x�����һ������11����10��1�ӵ�4����15��1�ӵ�5��֮��
            while (sum <= n) {
                sum = x * (1 + x) / 2;
                x++;
            }
            x--;//����whileѭ�������һ������
            //���1��n����һ���Ȳ��������һ�����ĺͣ�1+2+2+3+3+3+4+4+4+4
            for (int i = 1; i < x; i++) {
                result += (i * i);
            }
            //ʣ�µģ�+5
            for (int i = (x - 1) * x / 2; i < n; i++) {
                result += x;
            }
            return result;
        }
    }
}
