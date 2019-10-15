package Bit;

//169
//给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 [ n/2 ] 的元素。
//你可以假设数组是非空的，并且给定的数组总是存在众数。
//示例 1:
//输入: [3,2,3]
//输出: 3
//示例 2:
//输入: [2,2,1,1,1,2,2]
//输出: 2
public class majority_element {
    public static void main(String[] args) {
        System.out.println(new majority_element.Solution().majorityElement(new int[]{3}));
    }

    //众数：出现次数最多的数：每一位出现次数最多的
    static class Solution {
        public int majorityElement(int[] nums) {
            int zeroCount, oneCount, result = 0;
            int n = nums.length;
            for (int j = 0; j < 32; j++) {
                zeroCount = 0;
                oneCount = 0;
                for (int i = 0; i < n; i++) {
                    if (oneCount > n / 2 || zeroCount > n / 2) break;
                    if ((nums[i] & (1 << j)) != 0) {
                        oneCount++;
                    } else {
                        zeroCount++;
                    }
                }
                //记录当前位为1的
                if (oneCount > zeroCount) {
                    result |= (1 << j);
                }
            }
            return result;
        }
    }
}
