package Array_Matrix;

//1326
//�� x ������һ��һά�Ļ�԰����԰����Ϊ n���ӵ� 0 ��ʼ������ n ������
//��԰���ܹ��� n + 1 ��ˮ��ͷ���ֱ�λ�� [0, 1, ..., n] ��
//����һ������ n ��һ������Ϊ n + 1 ���������� ranges ������ ranges[i] ���±�� 0 ��ʼ����ʾ������򿪵� i ����ˮ��ͷ�����Թ�ȵ�����Ϊ [i -  ranges[i], i + ranges[i]] ��
//���㷵�ؿ��Թ��������԰�� ����ˮ��ͷ��Ŀ �������԰ʼ�մ����޷���ȵ��ĵط������㷵�� -1 ��
//
//ʾ�� 1��
//
//���룺n = 5, ranges = [3,4,1,1,0,0]
//�����1
//���ͣ�
//�� 0 ����ˮ��ͷ���Թ������ [-3,3]
//�� 1 ����ˮ��ͷ���Թ������ [-3,5]
//�� 2 ����ˮ��ͷ���Թ������ [1,3]
//�� 3 ����ˮ��ͷ���Թ������ [2,4]
//�� 4 ����ˮ��ͷ���Թ������ [4,4]
//�� 5 ����ˮ��ͷ���Թ������ [5,5]
//ֻ��Ҫ�򿪵� 1 ����ˮ��ͷ���ɹ��������԰ [0,5] ��
//ʾ�� 2��
//���룺n = 3, ranges = [0,0,0,0]
//�����-1
//���ͣ���ʹ������ˮ��ͷ����Ҳ�޷����������԰��
//ʾ�� 3��
//���룺n = 7, ranges = [1,2,1,0,2,1,0,1]
//�����3
//ʾ�� 4��
//���룺n = 8, ranges = [4,0,0,0,0,0,0,0,4]
//�����2
//ʾ�� 5��
//���룺n = 8, ranges = [4,0,0,0,4,0,0,0,4]
//�����1
//
//��ʾ��
//1 <= n <= 10^4
//ranges.length == n + 1
//0 <= ranges[i] <= 100
public class the_minimum_number_of_taps_for_irrigating_the_garden {
    public static void main(String[] args) {
        System.out.println(new the_minimum_number_of_taps_for_irrigating_the_garden.Solution().minTaps(
                8, new int[]{4, 0, 0, 0, 4, 0, 0, 0, 4}
        ));
    }

    public static class Solution {
        public int minTaps(int n, int[] ranges) {
            int[] map = new int[n + 1];
            for (int i = 0; i < ranges.length; i++) {
                if (i - ranges[i] < 0) {
                    map[0] = Math.max(map[0], i + ranges[i]);
                } else {
                    map[i - ranges[i]] = i + ranges[i];
                }
            }
            if (map[0] == 0) return -1;
            int max = map[0];
            int result = 1;
            int cur = map[0];
            for (int i = 1; i < map.length && cur < n; i++) {
                if (i <= cur) {
                    max = Math.max(max, map[i]);
                } else {
                    if (i > max) {
                        return -1;
                    } else {
                        cur = max;
                        max = map[i];
                        result++;
                    }
                }
            }
            if (cur < n) return -1;
            else return result;
        }
    }
}
