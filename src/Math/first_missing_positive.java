package Math;

//41
//给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
//
//示例 1:
//输入: [1,2,0]
//输出: 3
//示例 2:
//输入: [3,4,-1,1]
//输出: 2
//示例 3:
//输入: [7,8,9,11,12]
//输出: 1
public class first_missing_positive {
    public static void main(String[] args) {
        System.out.println(new first_missing_positive.Solution().firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    static class Solution {
        public int firstMissingPositive(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != i + 1) {
                    if (nums[i] <= 0 || nums[i] > nums.length || nums[i] == nums[nums[i] - 1]) {
                        break;
                    }
                    int temp = nums[i];
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }
    }
}
