package String;

//128
//给定一个未排序的整数数组，找出最长连续序列的长度。
//要求算法的时间复杂度为 O(n)。
//示例:
//输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
public class longest_consecutive_sequence {
    public static void main(String[] args) {
        System.out.println(new longest_consecutive_sequence.Solution().longestConsecutive(new int[]{
                2147483646, -2147483647, 0, 2, 2147483644, -2147483645, 2147483645
        }));
    }

    //哈希表 时间复杂度要求为0(n)
    //类似于计数排序
    //由于数组长度最大是32位int型的，因此特殊样例导致溢出
    static class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int maxNum = nums[0];
            int minNum = nums[0];
            for (int num : nums) {
                maxNum = Math.max(num, maxNum);
                minNum = Math.min(num, minNum);
            }
            int length = maxNum - minNum + 1;
            boolean[] hashtable = new boolean[length + 1];
            for (int num : nums) {
                hashtable[num - minNum] = true;
            }
            int result = 0;
            int current = 1;
            for (int i = 1; i < length + 1; i++) {
                if (hashtable[i - 1] && hashtable[i]) {
                    current++;
                    result = Math.max(current, result);
                } else {
                    current = 1;
                }
            }
            return result;
        }
    }
}
