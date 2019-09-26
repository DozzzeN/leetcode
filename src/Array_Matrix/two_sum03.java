package Array_Matrix;

import java.util.Arrays;

//1
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//给定 nums = [2, 7, 11, 15], target = 9
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
public class two_sum03 {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        two_sum03.Solution sol = new two_sum03.Solution();
        int[] result = sol.twoSum(nums, target);
        System.out.print(Arrays.toString(result));
    }

    public static class Node implements Comparable<Node> {
        public int oldIndex;//保存元素在原数组中的位置，因为后面需要排序，位置会变
        public int num;

        public Node(int oldIndex, int num) {
            this.oldIndex = oldIndex;
            this.num = num;
        }

        //重写排序方法
        @Override
        public int compareTo(Node o) {
            return num - o.num;
        }
    }

    static class Solution {
        //双指针法，指针位于首尾处，向中心靠拢 O(nlogn)
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            Node[] nodes = new Node[nums.length];
            for (int i = 0; i < nums.length; i++) {
                nodes[i] = new Node(i, nums[i]);
            }
            //需要先进行排序
            Arrays.sort(nodes);
            int start = 0, end = nums.length - 1;
            while (start < end) {
                int sum = nodes[start].num + nodes[end].num;
                if (sum == target) {
                    result[0] = Math.min(nodes[start].oldIndex, nodes[end].oldIndex);
                    result[1] = Math.max(nodes[start].oldIndex, nodes[end].oldIndex);
                    break;
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
            return result;
        }
    }
}


