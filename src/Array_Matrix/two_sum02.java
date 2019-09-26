package Array_Matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//1
//����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±ꡣ
//����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�
//���� nums = [2, 7, 11, 15], target = 9
//��Ϊ nums[0] + nums[1] = 2 + 7 = 9
//���Է��� [0, 1]
public class two_sum02 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        two_sum02.Solution sol = new two_sum02.Solution();
        int[] result = sol.twoSum(nums, target);
        System.out.print(Arrays.toString(result));
    }

    static class Solution {
        //�����ϣ��
        //ͨ���Կռ任ȡ�ٶȵķ�ʽ�����ǿ��Խ�����ʱ��� O(n) ���͵� O(1)��
        //��ϣ������Ϊ��Ŀ�Ķ������ģ���֧���� ���� �㶨��ʱ����п��ٲ��ҡ����á����ơ�������������Ϊһ�����ֳ�ͻ��
        //������ʱ���ܻ��˻��� O(n)����ֻҪ����ϸ����ѡ��ϣ�������ڹ�ϣ���н��в��ҵ���ʱӦ����̯��Ϊ O(1)1
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                //��ֹ�ظ�ʹ��ĳ��Ԫ��
                if (map.containsKey(complement) && map.get(complement) != i) {
                    return new int[]{i, map.get(complement)};
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }

        //һ���ϣ��
        public int[] twoSum2(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[]{map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }

    }
}


