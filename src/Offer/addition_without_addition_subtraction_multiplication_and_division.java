package Offer;

//https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&tqId=11201&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
public class addition_without_addition_subtraction_multiplication_and_division {
    public static void main(String[] args) {
        System.out.println(new addition_without_addition_subtraction_multiplication_and_division.Solution().Add(3, -1));
    }

    public static class Solution {
        //迭代的写法
        public int Add(int num1, int num2) {
            int count, carry;
            do {
                count = num1 ^ num2;//不进位的和
                carry = (num1 & num2) << 1;//进位
                num1 = count;
                num2 = carry;
            } while (carry != 0);//直到不产生进位
            return count;
        }

        //递归的写法
        //a^b表示没有考虑进位的情况下两数的和，(a&b)<<1就是进位。
        //递归会终止的原因是(a&b)<<1最右边会多一个0，那么继续递归，进位最右边的0会慢慢增多，最后进位会变为0，递归终止。
        public int Add02(int a, int b) {
            return b == 0 ? a : Add02(a ^ b, (a & b) << 1);
        }
    }
}
