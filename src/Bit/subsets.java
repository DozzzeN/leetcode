package Bit;

import java.util.ArrayList;
import java.util.List;

//78
//����һ�鲻���ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����
//˵�����⼯���ܰ����ظ����Ӽ���
//ʾ��:
//����: nums = [1,2,3]
//���:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
public class subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> result = new subsets.Solution().subsets(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    //ʹ��λ����
    //��1��2��3��Ӧ��λ����λ�͵�λ
    //1  2  3
    //0  0  0 []
    //0  0  1 [3]
    //0  1  0 [2]
    //0  1  1 [2,3]
    //......
    //1  1  1 [1,2,3]
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> solution = new ArrayList<>();
            int n = nums.length;
            int count = 1 << n;
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        solution.add(nums[j]);
                    }
                }
                result.add(solution);
                solution = new ArrayList<>();
            }
            return result;
        }
    }
}
