package Array_Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//15
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
public class three_sum {
    public static void main(String[] args) {
        int[] nums = new int[]{10,0,0};
        List<List<Integer>> result = new Solution().threeSum(nums);
        System.out.println(result);
    }

    //双指针法，将其转为两数和问题
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums.length < 3 || nums.equals("")) {
                return result;
            }
            //需要先进行排序
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                int target = 0 - nums[i];
                int start = i + 1, end = nums.length - 1;
                while (start < end) {
                    int sum = nums[start] + nums[end];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[start]);
                        list.add(nums[end]);
                        list.add(nums[i]);
                        Collections.sort(list);
                        result.add(list);
                        start++;
                        end--;
                        //内部去重 [-2,0,0,2,2]的结果是[-2,0,2]，去掉重复的[-2,0,2]
                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
                //外部去重 如[-1,-1,-1,0,1]
                while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
            return result;
        }
    }
}
