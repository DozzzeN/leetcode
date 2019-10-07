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
public class permutation03 {
    static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        int[] visited;

        public List<List<Integer>> permute(int[] nums) {
            this.visited = new int[nums.length];
            permute(nums, 0);
            return result;
        }
        //求解nums的所有排列，其中用visited去掉重复值
        public void permute(int[] nums, int start) {
            if (start == nums.length) {  // 输出
                result.add(new ArrayList<>(solution));
            } else {
                for (int i = 0; i < nums.length; ++i) {
                    if (visited[i] == 0) {
                        visited[i] = 1;
                        solution.add(nums[i]);
                        permute(nums, start + 1);  //交换后，再进行全排列算法
                        solution.remove(solution.size() - 1);
                        visited[i] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new permutation03.Solution().permute(new int[]{1, 2, 3});
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }
}


