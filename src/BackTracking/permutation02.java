package BackTracking;

import java.util.ArrayList;
import java.util.List;

//46
//����һ��û���ظ����ֵ����У����������п��ܵ�ȫ���С�
//ʾ��:
//����: [1,2,3]
//���:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
public class permutation02 {
    public static void main(String[] args) {
        List<List<Integer>> result = new permutation02.Solution().permute(new int[]{1, 2, 3});
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            permute(nums, 0);
            return result;
        }

        //start��ʾ��nums[start]������ݽ���ȫ����
        public void permute(int[] nums, int start) {
            if (start == nums.length) {  // ���
                List<Integer> solution = new ArrayList<>();
                for (int num : nums) {
                    solution.add(num);
                }
                result.add(solution);
            } else {
                for (int i = start; i < nums.length; ++i) {
                    swap(nums, start, i);  //  ����Ԫ��(��1,2,3�ֱ����������λ)
                    permute(nums, start + 1);  //�������ٽ���ȫ�����㷨
                    swap(nums, start, i);  //��ԭ��ԭ�������飬������һ�ε�ȫ����(�ٽ�����ȥ)
                }
            }
        }

        private void swap(int[] array, int s, int i) {
            int t = array[s];
            array[s] = array[i];
            array[i] = t;
        }
    }
}


