package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//40
//����һ������ candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
//candidates �е�ÿ��������ÿ�������ֻ��ʹ��һ�Ρ�
//˵����
//	�������֣�����Ŀ������������������
//	�⼯���ܰ����ظ�����ϡ�
//ʾ�� 1:
//����: candidates = [10,1,2,7,6,1,5], target = 8,
//����⼯Ϊ:
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
                //��Ҫ�����½�һ��ArrayList������֮��solution�ı�ʱresult����Ҳ����֮�ı�
                result.add(new ArrayList<>(solution));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                solution.push(candidates[i]);
                findCombinationSum(residue - candidates[i], i + 1, solution);
                //ѡ����һ����֧
                solution.pop();
                //Ԫ�ز������ظ�ʹ�ã����м�֦
                while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                    i++;
                }
            }
        }
    }
}
