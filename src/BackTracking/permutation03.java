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
public class permutation03 {
    static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        int[] visited;

        public List<List<Integer>> permute(int[] nums) {
            this.visited = new int[nums.length];
            permute(nums, 0);
            return result;
        }
        //���nums���������У�������visitedȥ���ظ�ֵ
        public void permute(int[] nums, int start) {
            if (start == nums.length) {  // ���
                result.add(new ArrayList<>(solution));
            } else {
                for (int i = 0; i < nums.length; ++i) {
                    if (visited[i] == 0) {
                        visited[i] = 1;
                        solution.add(nums[i]);
                        permute(nums, start + 1);  //�������ٽ���ȫ�����㷨
                        solution.remove(solution.size() - 1);
                        visited[i] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new permutation03.Solution().permute(new int[]{1, 2, 3});
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }
}


