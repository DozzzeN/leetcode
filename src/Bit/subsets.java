package Bit;

import java.util.ArrayList;
import java.util.List;

//78
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//说明：解集不能包含重复的子集。
//示例:
//输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
public class subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> result = new subsets.Solution().subsets(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    //使用位掩码
    //如1，2，3对应高位、中位和低位
    //1  2  3
    //0  0  0 []
    //0  0  1 [3]
    //0  1  0 [2]
    //0  1  1 [2,3]
    //......
    //1  1  1 [1,2,3]
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> solution = new ArrayList<>();
            int n = nums.length;
            int count = 1 << n;
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        solution.add(nums[j]);
                    }
                }
                result.add(solution);
                solution = new ArrayList<>();
            }
            return result;
        }
    }
}
