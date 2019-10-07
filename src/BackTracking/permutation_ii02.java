package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//42
//����һ���ɰ����ظ����ֵ����У��������в��ظ���ȫ���С�
//ʾ��:
//����: [1,1,2]
//���:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
public class permutation_ii02 {
    static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        int[] visited;

        private void findPermuteUnique(int[] nums, int depth) {
            if (depth == nums.length) {
                result.add(new ArrayList<>(solution));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] == 0) {
                    // �޸� 2����Ϊ�����Ժ��ظ�����һ����������ڿ�ʼ���� i > 0
                    // ��֮ǰ������ȣ�����֮ǰ������δʹ�ù���ֻ�г�������������Ż������ͬ��֧
                    // ���������������
                    if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                        continue;
                    }
                    visited[i] = 1;
                    solution.add(nums[i]);
                    findPermuteUnique(nums, depth + 1);
                    solution.remove(solution.size() - 1);
                    visited[i] = 0;
                }
            }
        }

        public List<List<Integer>> permuteUnique(int[] nums) {
            // �޸� 1����������֮����п��ܷ����ظ���֧
            Arrays.sort(nums);
            this.visited = new int[nums.length];
            findPermuteUnique(nums, 0);
            return result;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permuteUnique = new permutation_ii02.Solution().permuteUnique(new int[]{1, 1, 2});
        System.out.println(permuteUnique);
    }
}
