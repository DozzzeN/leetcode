package Bit;

//461
//��������֮��ĺ�������ָ�������������ֶ�Ӧ������λ��ͬ��λ�õ���Ŀ��
//������������ x �� y����������֮��ĺ������롣
//ע�⣺
//0 �� x, y < 231.
//ʾ��:
//����: x = 1, y = 4
//���: 2
//����:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ��   ��
//����ļ�ͷָ���˶�Ӧ������λ��ͬ��λ�á�
public class hamming_distance {
    public static void main(String[] args) {
        System.out.println(new hamming_distance.Solution().hammingDistance(0, Integer.MAX_VALUE));
    }

    static class Solution {
        public int hammingDistance(int x, int y) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                result += (((x & (1 << i)) ^ (y & (1 << i))) >> i);
            }
            return result;
        }
    }
}
