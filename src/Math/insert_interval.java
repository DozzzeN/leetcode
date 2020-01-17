package Math;

import java.util.Arrays;

//57
//给出一个无重叠的 ，按照区间起始端点排序的区间列表。
//在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
//示例 1:
//输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出: [[1,5],[6,9]]
//示例 2:
//输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出: [[1,2],[3,10],[12,16]]
//解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
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
