package Math;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

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
public class merge_intervals02 {
    public static void main(String[] args) {
        List<Solution.Interval> input = new LinkedList<>();
        input.add(new Solution.Interval(1, 3));
        input.add(new Solution.Interval(2, 6));
        input.add(new Solution.Interval(8, 10));
        input.add(new Solution.Interval(15, 18));
        List<Solution.Interval> result = new merge_intervals02.Solution().merge(input);
        System.out.println(result);
    }

    //����
    static class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            intervals.sort(Comparator.comparingInt(a -> a.start));

            LinkedList<Interval> merged = new LinkedList<>();
            for (Interval interval : intervals) {
                // if the list of merged intervals is empty or if the current
                // interval does not overlap with the previous, simply append it.
                if (merged.isEmpty() || merged.getLast().end < interval.start) {
                    merged.add(interval);
                }
                // otherwise, there is overlap, so we merge the current and previous intervals.
                else {
                    merged.getLast().end = Math.max(merged.getLast().end, interval.end);
                }
            }

            return merged;
        }

        static class Interval {
            int start;
            int end;

            public Interval(int start, int end) {
                this.start = start;
                this.end = end;
            }

            @Override
            public String toString() {
                return "Interval{" +
                        "start=" + start +
                        ", end=" + end +
                        '}';
            }
        }
    }
}
