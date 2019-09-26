package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//39
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//candidates 中的数字可以无限制重复被选取。
//说明：
//	所有数字（包括 target）都是正整数。
//	解集不能包含重复的组合。
//示例 1:
//输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
public class combination_sum {
    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        System.out.println(new combination_sum.Solution().combinationSum(candidates, 7));
    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        int[] candidates;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                //元素可以重复使用，故下一个元素是i而不是i+1
                findCombinationSum(residue - candidates[i], i, solution);
                //选择另一个分支
                solution.pop();
            }
        }
    }
}
