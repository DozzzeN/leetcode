package Array_Matrix;

public class remove_duplicates_from_sorted_array {
    public static void main(String[] args) {
        remove_duplicates_from_sorted_array.Solution solution = new remove_duplicates_from_sorted_array.Solution();
        int[] nums = new int[]{0,0,2,2,3,3,4};
        System.out.println("result：" + solution.removeDuplicates(nums));
    }

    //26
    //给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    //不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    static class Solution {
        public int removeDuplicates(int[] nums) {
            int len = nums.length;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; (j > i) && (j < nums.length); j++) {
                    if (i == len - 1) {//此时已经判断结束，数组末尾几位数字都相同，防止死循环则退出
                        return len;
                    }
                    if (nums[i] == nums[j]) {
                        for (int k = i; k < nums.length - 1; k++) {
                            nums[k] = nums[k + 1];
                        }
                        len--;
                        j--;//当数组左移以后，j指针也要左移
                    }
                }
            }
            return len;
        }
    }
}


    /*public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }*/