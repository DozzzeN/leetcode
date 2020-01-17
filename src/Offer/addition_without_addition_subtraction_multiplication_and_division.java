package Offer;

//https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&tqId=11201&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
public class addition_without_addition_subtraction_multiplication_and_division {
    public static void main(String[] args) {
        System.out.println(new addition_without_addition_subtraction_multiplication_and_division.Solution()
                .Add(3, -1));
    }

    public static class Solution {
        public int Add(int num1, int num2) {
            int count, carry;
            do {
                count = num1 ^ num2;
                carry = (num1 & num2) << 1;
//                result = count ^ carry;
                num1 = count;
                num2 = carry;
            } while (carry != 0);
            return count;
        }
    }
}
