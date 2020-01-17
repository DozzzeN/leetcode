package BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//77
//������������ n �� k������ 1 ... n �����п��ܵ� k ��������ϡ�
//ʾ��:
//����: n = 4, k = 2
//���:
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
            //��֦
            for (int i = start; i < n - k + solution.size() + 1; i++) {
                solution.push(i + 1);
                getCombine(i + 1, solution, k, n);
                solution.pop();
            }
        }
    }
}
