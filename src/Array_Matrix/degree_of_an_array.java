package Array_Matrix;

import java.util.*;
//697
//给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
//你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
public class degree_of_an_array {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 3, 1};
        System.out.println(new Solution().findShortestSubArray(nums));
    }

    static class Solution {
        public int findShortestSubArray(int[] nums) {
            //原数组的拷贝
            List<Integer> tempArray = new ArrayList<>(nums.length);
            for (int i : nums) {
                tempArray.add(i);
            }
            //存放原数组元素（键）和该元素出现次数（值）
            Map<Integer, Integer> NumberElements = new HashMap<>();
            for (int i = 0; i < tempArray.size(); i++) {
                if (((NumberElements.get(tempArray.get(i)) != null)) &&
                        (NumberElements.containsKey(tempArray.get(i)))) {
                    //重复则次数加一
                    int tmp = NumberElements.get(tempArray.get(i));
                    NumberElements.remove(tempArray.get(i));
                    NumberElements.put(tempArray.get(i), tmp + 1);
                } else {
                    //第一次出现次数为一
                    NumberElements.put(tempArray.get(i), 1);
                }
            }
            int MaxCounts = 0;
            for (int i : NumberElements.values()) {
                //找到最大次数
                MaxCounts = Math.max(i, MaxCounts);
            }
            int MaxNum;
            int MinDegree = tempArray.size();
            for (int i : NumberElements.keySet()) {
                if (NumberElements.get(i) == MaxCounts) {
                    //出现最大次数的元素
                    MaxNum = i;
                    //元素构成子序列的最短长度，最大次数的元素不唯一
                    MinDegree = Math.min(MinDegree, tempArray.lastIndexOf(MaxNum) - tempArray.indexOf(MaxNum) + 1);
                }

            }
            return MinDegree;
        }
    }
}
