package Array_Matrix;

//27
//给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
//不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
//元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
public class remove_element {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new Solution().removeElement(nums, 2));
        for (int i : nums) {
            System.out.print(i + "\t");
        }
    }

    static class Solution {
//        public int removeElement(int[] nums, int val) {
//            int result = 0;
//            for (int i = nums.length - 1; i >= 0; i--) {
//                if (nums[i] == val) {
//                    if (i != nums.length - 1) {
//                        for (int j = i; j < nums.length - 1; j++) {
//                            nums[j] = nums[j + 1];
//                        }
//                    }
//                } else {
//                    result++;
//                }
//            }
//            return result;
//        }

        //双指针，i用来遍历数组，cur用来维护新字符串的右边界
        public int removeElement(int[] nums, int val) {
            int cur = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[cur++] = nums[i];
                }
            }
            return cur;
        }
    }
}
