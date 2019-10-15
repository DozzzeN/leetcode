package Math;

//69
//ʵ�� int sqrt(int x) ������
//
//���㲢���� x ��ƽ���������� x �ǷǸ�������
//���ڷ������������������ֻ���������Ĳ��֣�С�����ֽ�����ȥ��
//ʾ�� 1:
//����: 4
//���: 2
//ʾ�� 2:
//����: 8
//���: 2
//˵��: 8 ��ƽ������ 2.82842...,
//     ���ڷ���������������С�����ֽ�����ȥ��
public class sqrtx {
    public static void main(String[] args) {
        System.out.println(new sqrtx.Solution().mySqrt(6));
    }
    //���ַ�
    static class Solution {
        public int mySqrt(int x) {
            if (x == 1) return 1;
            long start = 0, end = x >>> 1;
            while (start <= end) {
                long mid = (start + end) >>> 1;
                long sqr = mid * mid;
                if (sqr > x) {
                    end = mid - 1;
                } else if (sqr < x) {
                    start = mid + 1;
                } else if (sqr == x) {
                    return (int) mid;
                }
            }
            return (int) end;
        }
    }
}
