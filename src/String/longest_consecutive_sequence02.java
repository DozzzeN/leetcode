package String;

import java.util.HashSet;
import java.util.Set;

//128
//给定一个未排序的整数数组，找出最长连续序列的长度。
//要求算法的时间复杂度为 O(n)。
//示例:
//输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
public class longest_consecutive_sequence02 {
    public static void main(String[] args) {
        System.out.println(new longest_consecutive_sequence02.Solution().longestConsecutive(new int[]{
                2147483646, -2147483647, 0, 2, 2147483644, -2147483645, 2147483645
        }));
    }

    //哈希表 时间复杂度要求为0(n)
    //类似于计数排序
    static class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            Set<Integer> hashTable = new HashSet<>();
            for (int num : nums) {
                hashTable.add(num);
            }
            int result = 1;
            int longLength;
            //也有动态规划的思想
            //D[num] = D[num-1] + 1 if num-1 in the map
            //       = 1 if num-1 not in the map
            for (int num : nums) {
                longLength = 1;
                int currentNum = num;
                while (hashTable.contains(currentNum + 1)) {
                    currentNum++;
                    longLength++;
                }
                result = Math.max(result, longLength);
            }
            return result;
        }
    }
}
