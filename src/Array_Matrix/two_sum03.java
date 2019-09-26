package Array_Matrix;

import java.util.Arrays;

//1
//����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±ꡣ
//����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�
//���� nums = [2, 7, 11, 15], target = 9
//��Ϊ nums[0] + nums[1] = 2 + 7 = 9
//���Է��� [0, 1]
public class two_sum03 {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        two_sum03.Solution sol = new two_sum03.Solution();
        int[] result = sol.twoSum(nums, target);
        System.out.print(Arrays.toString(result));
    }

    public static class Node implements Comparable<Node> {
        public int oldIndex;//����Ԫ����ԭ�����е�λ�ã���Ϊ������Ҫ����λ�û��
        public int num;

        public Node(int oldIndex, int num) {
            this.oldIndex = oldIndex;
            this.num = num;
        }

        //��д���򷽷�
        @Override
        public int compareTo(Node o) {
            return num - o.num;
        }
    }

    static class Solution {
        //˫ָ�뷨��ָ��λ����β���������Ŀ�£ O(nlogn)
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            Node[] nodes = new Node[nums.length];
            for (int i = 0; i < nums.length; i++) {
                nodes[i] = new Node(i, nums[i]);
            }
            //��Ҫ�Ƚ�������
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


