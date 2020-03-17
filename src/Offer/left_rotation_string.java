package Offer;

//https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=13&tqId=11196&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//题目描述
//汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
//对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
//要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
public class left_rotation_string {
    public static void main(String[] args) {
        System.out.println(new left_rotation_string.Solution().LeftRotateString(
                "abcdefghi", 3
        ));
    }

    //X为str前n位，Y为str剩下的，str原本是X||Y，现在要求Y||X
    //设X的反转为X'，Y的反转为Y'
    //Y||X=(X'||Y')'
    public static class Solution {
        public String LeftRotateString(String str, int n) {
            if (str == null || str.length() == 0 || n > str.length()) return "";
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < n / 2; i++) {
                char c = sb.charAt(i);
                sb.replace(i, i + 1, str.charAt(n - i - 1) + "");
                sb.replace(n - i - 1, n - i, c + "");
            }
            for (int i = 0; i < (str.length() - n) / 2; i++) {
                char c = sb.charAt(i + n);
                sb.replace(i + n, i + n + 1, str.charAt(str.length() - i - 1) + "");
                sb.replace(str.length() - i - 1, str.length() - i, c + "");
            }
            return sb.reverse().toString();
        }
    }
}
