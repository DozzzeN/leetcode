package Array_Matrix;

import java.util.Arrays;

//645
//���� S ������1�� n �����������ҵ��ǣ���Ϊ���ݴ��󣬵��¼�������ĳһ��Ԫ�ظ����˳��˼������������һ��Ԫ�ص�ֵ��
// ���¼��϶�ʧ��һ������������һ��Ԫ���ظ���
//����һ������ nums �����˼��� S ���������Ľ�����������������Ѱ�ҵ��ظ����ֵ����������ҵ���ʧ�����������������������ʽ���ء�
//����: nums = [1,2,2,4]
//���: [2,3]
public class set_mismatch {
    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 2};
        System.out.println(Arrays.toString(new set_mismatch.Solution().findErrorNums(input)));
    }

    //��ֱ�ӵķ������ȶ���������������ַ���ʱ�临�Ӷ�Ϊ O(NlogN)��
    // ��������� O(N) ��ʱ�临�Ӷȡ�O(1) �ռ临�Ӷ�����⡣
    //��Ҫ˼����ͨ����������Ԫ�أ�ʹ�������ϵ�Ԫ������ȷ��λ���ϡ�
    // �������飬����� i λ�ϵ�Ԫ�ز��� i + 1����ôһֱ������ i λ�� nums[i] - 1 λ���ϵ�Ԫ�ء�
    static class Solution {
        public int[] findErrorNums(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    return new int[]{nums[i], i + 1};
                }
            }
            return null;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
