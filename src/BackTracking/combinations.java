package BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//77
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//示例:
//输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
public class combinations {
    public static void main(String[] args) {
        System.out.println(new combinations.Solution().combine(4, 3));
    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            getCombine(0, new Stack<>(), k, n);
            return result;
        }

        public void getCombine(int start, Stack<Integer> solution, int k, int n) {

            if (solution.size() == k) {
                result.add(new ArrayList<>(solution));
                return;
            }
            //for (int i = start; i < n; i++) {
            //剪枝
            for (int i = start; i < n - k + solution.size() + 1; i++) {
                solution.push(i + 1);
                getCombine(i + 1, solution, k, n);
                solution.pop();
            }
        }
    }
}
