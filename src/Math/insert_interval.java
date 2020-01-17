package Math;

import java.util.Arrays;

//57
//����һ�����ص��� ������������ʼ�˵�����������б�
//���б��в���һ���µ����䣬����Ҫȷ���б��е�������Ȼ�����Ҳ��ص�������б�Ҫ�Ļ������Ժϲ����䣩��
//ʾ�� 1:
//����: intervals = [[1,3],[6,9]], newInterval = [2,5]
//���: [[1,5],[6,9]]
//ʾ�� 2:
//����: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//���: [[1,2],[3,10],[12,16]]
//����: ������Ϊ�µ����� [4,8] �� [3,5],[6,7],[8,10] �ص���
public class insert_interval {
    public static void main(String[] args) {
        int[][] result = new insert_interval.Solution().insert(
                new int[][]{{3, 5}, {12, 15}},
                new int[]{6, 6}
        );
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static class Solution {
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
