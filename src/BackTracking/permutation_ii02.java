package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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
public class permutation_ii02 {
    static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        int[] visited;

        private void findPermuteUnique(int[] nums, int depth) {
            if (depth == nums.length) {
                result.add(new ArrayList<>(solution));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] == 0) {
                    // 修改 2：因为排序以后重复的数一定不会出现在开始，故 i > 0
                    // 和之前的数相等，并且之前的数还未使用过，只有出现这种情况，才会出现相同分支
                    // 这种情况跳过即可
                    if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                        continue;
                    }
                    visited[i] = 1;
                    solution.add(nums[i]);
                    findPermuteUnique(nums, depth + 1);
                    solution.remove(solution.size() - 1);
                    visited[i] = 0;
                }
            }
        }

        public List<List<Integer>> permuteUnique(int[] nums) {
            // 修改 1：首先排序，之后才有可能发现重复分支
            Arrays.sort(nums);
            this.visited = new int[nums.length];
            findPermuteUnique(nums, 0);
            return result;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permuteUnique = new permutation_ii02.Solution().permuteUnique(new int[]{1, 1, 2});
        System.out.println(permuteUnique);
    }
}
