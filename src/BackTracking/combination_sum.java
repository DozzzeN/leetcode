package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//39
//����һ�����ظ�Ԫ�ص����� candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
//candidates �е����ֿ����������ظ���ѡȡ��
//˵����
//	�������֣����� target��������������
//	�⼯���ܰ����ظ�����ϡ�
//ʾ�� 1:
//����: candidates = [2,3,6,7], target = 7,
//����⼯Ϊ:
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
                //��Ҫ�����½�һ��ArrayList������֮��solution�ı�ʱresult����Ҳ����֮�ı�
                result.add(new ArrayList<>(solution));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                solution.push(candidates[i]);
                //Ԫ�ؿ����ظ�ʹ�ã�����һ��Ԫ����i������i+1
                findCombinationSum(residue - candidates[i], i, solution);
                //ѡ����һ����֧
                solution.pop();
            }
        }
    }
}
