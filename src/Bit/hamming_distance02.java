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
public class hamming_distance02 {
    public static void main(String[] args) {
        System.out.println(new hamming_distance02.Solution().hammingDistance(0, Integer.MAX_VALUE));
    }

    static class Solution {
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }
}
