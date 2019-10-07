package Array_Matrix;

import java.util.Arrays;

//80
//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
//不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
//示例 1:
//给定 nums = [1,1,1,2,2,3],
//函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
//你不需要考虑数组中超出新长度后面的元素。
//示例 2:
//给定 nums = [0,0,1,1,1,1,2,3,3],
//函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
//你不需要考虑数组中超出新长度后面的元素。
public class remove_duplicates_from_sorted_array_ii {
    public static void main(String[] args) {
        remove_duplicates_from_sorted_array_ii.Solution solution = new remove_duplicates_from_sorted_array_ii.Solution();
        int[] nums = new int[]{1, 1, 1, 1, 2, 2, 3};
        System.out.println("result：" + solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    //尚未理解
    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) return 0;
            int occur = 1;
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    occur = 1;
                } else {
                    //使得occur最多为2
                    if (occur == 2) {
                        continue;
                    } else {
                        occur++;
                    }
                }
                //只要occur不等于2，无论nums[i]和nums[j]是否相等都要进行复制j元素（复制的次数最多为2）
                i++;
                nums[i] = nums[j];
            }
            return i + 1;
        }
    }
}
