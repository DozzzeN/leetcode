package String;

import java.util.Arrays;

//67
//给定两个二进制字符串，返回他们的和（用二进制表示）。
//输入为非空字符串且只包含数字 1 和 0。
//输入: a = "1010", b = "1011"
//输出: "10101"
public class add_binary {
    public static void main(String[] args) {
        String a = "1";
        String b = "111";
        System.out.println(new Solution().addBinary(a, b));
    }

    static class Solution {
        public String addBinary(String a, String b) {
            int[] A = new int[a.length()];
            int[] B = new int[b.length()];
            int[] C = new int[Math.max(a.length(), b.length()) + 1];
            for (int i = 0; i < a.length(); i++) {
                A[i] = a.charAt(i) - '0';
            }
            for (int i = 0; i < b.length(); i++) {
                B[i] = b.charAt(i) - '0';
            }

            int carry = 0;
            for (int i = A.length - 1, j = B.length - 1; i >= 0 || j >= 0; i--, j--) {
                int ai = i >= 0 ? A[i] : 0;
                int bj = j >= 0 ? B[j] : 0;

                C[Math.max(i, j) + 1] = (ai + bj + carry) % 2;
                carry = (ai + bj + carry) / 2;
            }
            if (carry != 0) {
                C[0] = carry;
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < C.length; i++) {
                result.append(C[i]);
            }
            if (result.charAt(0) == '0') {
                result = result.delete(0, 1);
            }
            return result.toString();
        }
    }
}
