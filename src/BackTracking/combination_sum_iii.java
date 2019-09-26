package BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//216
//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//说明：
//	所有数字都是正整数。
//	解集不能包含重复的组合。
//示例 1:
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//示例 2:
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
public class combination_sum_iii {
    public static void main(String[] args) {
        System.out.println(new combination_sum_iii.Solution().combinationSum3(3, 9));
    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        int[] candidates = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        public List<List<Integer>> combinationSum3(int k, int n) {
            findCombinationSum(k, n, 0, new Stack<>());
            return result;
        }


        public void findCombinationSum(int size, int residue, int start, Stack<Integer> solution) {
            if (residue < 0) {
                return;
            }
            if (residue == 0) {
                //需要重新新建一个ArrayList，否则之后solution改变时result里面也会随之改变
                if (solution.size() == size) {
                    result.add(new ArrayList<>(solution));
                }
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                solution.push(candidates[i]);
                findCombinationSum(size, residue - candidates[i], i + 1, solution);
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
