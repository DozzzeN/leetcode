package Array_Matrix;

import java.util.Arrays;

//31
//ʵ�ֻ�ȡ��һ�����еĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С�
//�����������һ����������У��������������г���С�����У����������У���
//����ԭ���޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣
//������һЩ���ӣ�����λ������У�����Ӧ���λ���Ҳ��С�
//1,2,3 �� 1,3,2
//3,2,1 �� 1,2,3
//1,1,5 �� 1,5,1
public class next_permutation {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 7, 5, 3, 2};
        new next_permutation.Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    static class Solution {
        public void nextPermutation(int[] nums) {
            int PartitionNumber = nums.length - 1;
            int changeNumber = 0;
            for (int i = PartitionNumber; i > 0; i--) {
                if (nums[i - 1] < nums[i]) {
                    PartitionNumber = i - 1;
                    break;
                }
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[PartitionNumber]) {
                    changeNumber = i;
                    break;
                }
            }
            if (PartitionNumber == nums.length - 1) {
                for (int i = 0; i < nums.length / 2; i++) {
                    nums[i] = nums[nums.length - i - 1] + nums[i];
                    nums[nums.length - i - 1] = nums[i] - nums[nums.length - i - 1];
                    nums[i] = nums[i] - nums[nums.length - i - 1];
                }
                return;
            }
            int temp = nums[changeNumber];
            nums[changeNumber] = nums[PartitionNumber];
            nums[PartitionNumber] = temp;
            PartitionNumber++;
            int end = nums.length - 1;
            while (PartitionNumber < end) {
                nums[PartitionNumber] = nums[end] + nums[PartitionNumber];
                nums[end] = nums[PartitionNumber] - nums[end];
                nums[PartitionNumber] = nums[PartitionNumber] - nums[end];
                end--;
                PartitionNumber++;
            }
        }
    }
}
