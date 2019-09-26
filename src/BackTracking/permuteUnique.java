package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class permuteUnique {

    private static List<List<Integer>> res = new ArrayList<>();
    private static boolean[] used;

    private static void findPermuteUnique(int[] nums, int depth, Stack<Integer> stack) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                // �޸� 2����Ϊ�����Ժ��ظ�����һ����������ڿ�ʼ���� i > 0
                // ��֮ǰ������ȣ�����֮ǰ������δʹ�ù���ֻ�г�������������Ż������ͬ��֧
                // ���������������
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                stack.add(nums[i]);
                findPermuteUnique(nums, depth + 1, stack);
                stack.pop();
                used[i] = false;
            }
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        // �޸� 1����������֮����п��ܷ����ظ���֧
        Arrays.sort(nums);
        used = new boolean[len];
        findPermuteUnique(nums, 0, new Stack<>());
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> permuteUnique = permuteUnique(nums);
        System.out.println(permuteUnique);
    }
}
