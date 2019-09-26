package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//40
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//candidates 中的每个数字在每个组合中只能使用一次。
//说明：
//	所有数字（包括目标数）都是正整数。
//	解集不能包含重复的组合。
//示例 1:
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
public class combination_sum_ii {
    public static void main(String[] args) {
        int[] candidates = new int[]{1, 2, 3};
        System.out.println(new combination_sum_ii.Solution().combinationSum2(candidates, 8));
    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        int[] candidates;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            this.candidates = candidates;
            findCombinationSum(target, 0, new Stack<>());
            return result;
        }


        public void findCombinationSum(int residue, int start, Stack<Integer> solution) {
            if (residue < 0) {
                return;
            }
            if (residue == 0) {
                //需要重新新建一个ArrayList，否则之后solution改变时result里面也会随之改变
                result.add(new ArrayList<>(solution));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                solution.push(candidates[i]);
                findCombinationSum(residue - candidates[i], i + 1, solution);
                //选择另一个分支
                solution.pop();
                //元素不可以重复使用，进行剪枝
                while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                    i++;
                }
            }
        }
    }
}
