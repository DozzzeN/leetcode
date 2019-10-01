package Array_Matrix;

import java.util.Arrays;

//66
//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//你可以假设除了整数 0 之外，这个整数不会以零开头。
//示例 1:
//输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
//示例 2:
//输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
public class plus_one {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new plus_one.Solution().plusOne(new int[]{9, 9, 9, 9})));
    }

    static class Solution {
        public int[] plusOne(int[] digits) {
            int sum = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                sum += digits[i];
                if (sum > 9) {
                    digits[i] = sum % 10;
                    sum /= 10;
                } else {
                    digits[i] = sum;
                    break;
                }
            }
            if (digits[0] == 0) {
                int[] newArray = new int[digits.length + 1];
                newArray[0] = 1;
                //可以不用拷贝，因为默认为0
                //System.arraycopy(digits, 0, newArray, 1, digits.length);
                return newArray;
            }
            return digits;
        }
    }
}
