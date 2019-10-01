package Math;

import java.util.Arrays;

//56
//给出一个区间的集合，请合并所有重叠的区间。
//示例 1:
//输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//示例 2:
//输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
public class merge_intervals {
    public static void main(String[] args) {
        int[][] result = new merge_intervals.Solution().merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        });
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    //创建一个新的集合，将原来的间隔一个个加入合并到新的集合中
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
            //当前区间的end小于插入区间的start，跳过并加入结果集
            if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
                result = new int[1][];
                result[0] = newInterval;
                return result;
            }
            while (i < n && intervals[i][1] < newInterval[0]) {
                i++;
            }
            //如果到最后都没找到，把newInterval加到最后
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
            //选择小的作为新区的 start
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
            //如果当前的start<end把当前end和newInterval的end比较
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

            //如果后面有没遍历到的加入最后的结果
            return result;
        }
    }
}
