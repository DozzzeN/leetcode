package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class permutation_sequence {
    public static void main(String[] args) {
        System.out.println(new permutation_sequence.Solution().getPermutation(9, 4));
    }

    //��ʱ
    static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        int[] visited;

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

        public String getPermutation(int n, int k) {
            this.visited = new int[n];
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }
            permute(nums, 0);
            StringBuilder s = new StringBuilder();
            for (Integer integer : result.get(k - 1)) {
                s.append(integer);
            }
            return s.toString();
        }
    }
}
