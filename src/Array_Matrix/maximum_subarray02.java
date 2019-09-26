package Array_Matrix;

public class maximum_subarray02 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));
    }

    //��̬�滮
    static class Solution {
        public int maxSubArray(int[] nums) {
            int result = nums[0];
            int temp = nums[0];
            for (int i = 1; i < nums.length; i++) {
                //���temp�Ǹ�������ѡ��nums[i]����֮ǰ��temp
                //�Ƚ�ԭ���Ľ�������µ������µ����Ĵ�С
                temp = Math.max(nums[i] + temp, nums[i]);//����һλ�ĵ�ǰ���Ž�
                //�Ƚ�ԭ���Ľ����ԭ���Ľ�������µ����Ĵ�С
                result = Math.max(result, temp);
            }
            return result;

            //�ڶ��ַ���ԭ��һ����ֻ�������Ǹ��������ʡ����͵��ж�
//            int maxSum = 0;
//            int thisSum = 0;
//            for (int i = 0; i < nums.length; i++) {
//                thisSum += nums[i];
//                if (thisSum > maxSum) {
//                    maxSum = thisSum;
//                } else if (thisSum < 0) {
//                    thisSum = 0;
//                }
//            }
//            return maxSum;
        }
    }
}
