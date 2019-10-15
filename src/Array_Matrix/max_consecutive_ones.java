package Array_Matrix;

//485
//给定一个二进制数组， 计算其中最大连续1的个数。
public class max_consecutive_ones {

    public static void main(String[] args) {
        int[] input = new int[]{1, 1, 0, 1, 1, 1};
        System.out.println(new Solution().findMaxConsecutiveOnes(input));

    }

    static class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int num = 0;
            int temp = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    num++;
                }
                if (nums[i] == 0) {
                    temp = Math.max(temp, num);
                    num = 0;
                }
            }
            return Math.max(num, temp);
        }
    }
}
