package Math;

public class permutation_sequence02 {
    public static void main(String[] args) {
        System.out.println(new permutation_sequence02.Solution().getPermutation(3, 6));
    }

    //找规律，看不懂
    static class Solution {
        public String getPermutation(int n, int k) {
            int permCount = 1;
            int[] nums = new int[n + 1];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
                permCount *= (i + 1);
            }
            k--;
            StringBuilder targetNum = new StringBuilder();
            for (int i = 0; i < n; i++) {
                permCount /= (n - i);
                int choosed = k / permCount;
                targetNum.append(nums[choosed]);
                for (int j = choosed; j < n - i; j++) {
                    nums[j] = nums[j + 1];
                }
                k %= permCount;
            }
            return targetNum.toString();
        }
    }
}
