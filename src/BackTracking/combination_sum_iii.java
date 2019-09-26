package BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//216
//�ҳ��������֮��Ϊ n �� k ��������ϡ������ֻ������ 1 - 9 ��������������ÿ������в������ظ������֡�
//˵����
//	�������ֶ�����������
//	�⼯���ܰ����ظ�����ϡ�
//ʾ�� 1:
//����: k = 3, n = 7
//���: [[1,2,4]]
//ʾ�� 2:
//����: k = 3, n = 9
//���: [[1,2,6], [1,3,5], [2,3,4]]
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
                //��Ҫ�����½�һ��ArrayList������֮��solution�ı�ʱresult����Ҳ����֮�ı�
                if (solution.size() == size) {
                    result.add(new ArrayList<>(solution));
                }
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                solution.push(candidates[i]);
                findCombinationSum(size, residue - candidates[i], i + 1, solution);
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
