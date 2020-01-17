package Offer;

//https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2?tpId=13&tqId=11206&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
//例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
//但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
public class string_representing_the_value {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNumeric(new char[]{'1', 'e', '1', '.', '6'}));
    }

    static public class Solution {
        public boolean isNumeric(char[] str) {
            char[] number = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
            char[] head = new char[]{'+', '-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
            int countE = 0;//出现e/E的个数
            int countDot = 0;//出现.的个数
            for (int i = 0; i < str.length; i++) {
                if (i == 0) {//第一位判断
                    boolean flag = false;
                    for (char c : head) {
                        if (str[0] == c) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        return false;
                    }
                } else {
                    boolean flag = false;
                    for (char c : number) {
                        if (str[i] == c) {
                            flag = true;
                            break;
                        }
                    }
                    if (str[i] == 'e' || str[i] == 'E') {//记录出现e/E的次数，但不能出现在最后一位
                        countE++;
                        flag = i != str.length - 1;
                    } else if (str[i] == '.') {//记录出现.的次数，但不能出现在e/E之后
                        if (countE > 0) {
                            return false;
                        } else {
                            countDot++;
                            flag = true;
                        }
                    } else if (str[i] == '+' || str[i] == '-') {//+/-只能出现在e/E之后
                        flag = str[i - 1] == 'e' || str[i - 1] == 'E';
                    }
                    if (!flag || countE > 1 || countDot > 1) {//e/E/.只能出现一次
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
