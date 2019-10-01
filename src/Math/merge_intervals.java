package Math;

import java.util.Arrays;

//56
//����һ������ļ��ϣ���ϲ������ص������䡣
//ʾ�� 1:
//����: [[1,3],[2,6],[8,10],[15,18]]
//���: [[1,6],[8,10],[15,18]]
//����: ���� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].
//ʾ�� 2:
//����: [[1,4],[4,5]]
//���: [[1,5]]
//����: ���� [1,4] �� [4,5] �ɱ���Ϊ�ص����䡣
public class merge_intervals {
    public static void main(String[] args) {
        int[][] result = new merge_intervals.Solution().merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        });
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    //����һ���µļ��ϣ���ԭ���ļ��һ��������ϲ����µļ�����
    static class Solution {
        public int[][] merge(int[][] intervals) {
            int[][] result = new int[][]{};
            for (int i = 0; i < intervals.length; i++) {
                result = insert(result, intervals[i]);
            }
            return result;
        }

        public int[][] insert(int[][] intervals, int[] newInterval) {
            int[][] result;
            int i = 0;
            int n = intervals.length;
            int nEnd = newInterval[1];
            //��ǰ�����endС�ڲ��������start����������������
            if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
                result = new int[1][];
                result[0] = newInterval;
                return result;
            }
            while (i < n && intervals[i][1] < newInterval[0]) {
                i++;
            }
            //��������û�ҵ�����newInterval�ӵ����
            if (i == n) {
                int j;
                result = new int[intervals.length + 1][];
                for (j = 0; j < intervals.length; j++) {
                    result[j] = intervals[j];
                }
                result[j] = newInterval;
                return result;
            }
            if (intervals[i][0] > newInterval[1]) {
                result = new int[intervals.length + 1][];
                for (int j = 0; j < i; j++) {
                    result[j] = intervals[j];
                }
                result[i] = newInterval;
                for (int j = i; j < intervals.length; j++) {
                    result[j + 1] = intervals[j];
                }
                return result;
            }
            //ѡ��С����Ϊ������ start
            int key = i;
            if (key == 0 && newInterval[1] < intervals[0][0]) {
                result = new int[intervals.length + 1][];
                result[0] = newInterval;
                for (int j = 1; j <= intervals.length; j++) {
                    result[j] = intervals[j - 1];
                }
                return result;
            }
            intervals[key][0] = Math.min(intervals[i][0], newInterval[0]);
            //�����ǰ��start<end�ѵ�ǰend��newInterval��end�Ƚ�
            while (i < n && intervals[i][0] <= newInterval[1]) {
                nEnd = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
            intervals[key][1] = nEnd;
            result = new int[key + 1 + intervals.length - i][];
            for (int j = 0; j <= key; j++) {
                result[j] = intervals[j];
            }
            for (int j = i; j < intervals.length; j++) {
                result[key + j - i + 1] = intervals[j];
            }

            //���������û�������ļ������Ľ��
            return result;
        }
    }
}
