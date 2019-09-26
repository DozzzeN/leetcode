package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//42
//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//示例:
//输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
public class permutation_ii {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2};
        List<List<Integer>> result = new permutation_ii.Solution().permuteUnique(nums);
        System.out.println(result);
    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public static void swap(int[] array, int s, int i) {
            int t = array[s];
            array[s] = array[i];
            array[i] = t;
        }

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            permuteUnique(nums, 0);
            return result;
        }

        public void permuteUnique(int[] nums, int start) {
            if (start == nums.length) {
                List<Integer> temp = new ArrayList<>();
                for (int num : nums) {
                    temp.add(num);
                }
                if (!result.contains(temp)) {
                    result.add(temp);
                }
            } else {
                for (int i = start; i < nums.length; i++) {
                    if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                        continue;
                    }
                    swap(nums, start, i);
                    permuteUnique(nums, start + 1);
                    swap(nums, start, i);
                }
            }
        }
    }
}

