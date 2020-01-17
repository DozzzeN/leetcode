package String;

//6
//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
//比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
//L   C   I   R
//E T O E S I I G
//E   D   H   N
//之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
//请你实现这个将字符串进行指定行数变换的函数：
//string convert(string s, int numRows);
//示例 1:
//输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
//示例 2:
//输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G
public class zigzag_conversion {
    public static void main(String[] args) {
        System.out.println(new zigzag_conversion.Solution().convert("123456789", 1));
    }

    //观察每行数字的递增规律(相当于官方题解的按行访问)
    //numRows = 4 (step)
    //(6)    1    7      13
    //(4)(2) 2  6 8   12 14
    //(2)(4) 3 5  9 11   15
    //(6)    4   10      16
    static class Solution {
        public String convert(String s, int numRows) {
            StringBuilder result = new StringBuilder();
            int step = numRows == 1 ? 1 : numRows * 2 - 2;
            for (int i = 0; i < numRows; i++) {
                if (i == 0 || i == numRows - 1) {
                    for (int j = i; j < s.length(); j += step) {
                        result.append(s.charAt(j));
                    }
                } else {
                    boolean flag = true;
                    int partStep = step - i * 2;
                    for (int j = i; j < s.length(); ) {
                        result.append(s.charAt(j));
                        if (flag) {
                            j += partStep;
                        } else {
                            j += (step - partStep);
                        }
                        flag = !flag;
                    }
                }
            }
            return result.toString();
        }
    }
}
