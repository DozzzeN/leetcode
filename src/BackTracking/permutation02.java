package BackTracking;

import java.util.ArrayList;
import java.util.List;

//46
//给定一个没有重复数字的序列，返回其所有可能的全排列。
//示例:
//输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
public class permutation02 {
    public static void main(String[] args) {
        List<List<Integer>> result = new permutation02.Solution().permute(new int[]{1, 2, 3});
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            permute(nums, 0);
            return result;
        }

        //start表示，nums[start]后的数据进行全排列
        public void permute(int[] nums, int start) {
            if (start == nums.length) {  // 输出
                List<Integer> solution = new ArrayList<>();
                for (int num : nums) {
                    solution.add(num);
                }
                result.add(solution);
            } else {
                for (int i = start; i < nums.length; ++i) {
                    swap(nums, start, i);  //  交换元素(将1,2,3分别放在数组首位)
                    permute(nums, start + 1);  //交换后，再进行全排列算法
                    swap(nums, start, i);  //还原成原来的数组，便于下一次的全排列(再交换回去)
                }
            }
        }

        private void swap(int[] array, int s, int i) {
            int t = array[s];
            array[s] = array[i];
            array[i] = t;
        }
    }
}


