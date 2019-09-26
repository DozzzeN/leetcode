package Math;

//38
//报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//1 被读作  "one 1"  ("一个一") , 即 11。
//11 被读作 "two 1s" ("两个一"）, 即 21。
//21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
//给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
//注意：整数顺序将表示为一个字符串。
//示例 1:
//输入: 1
//输出: "1"
//示例 2:
//输入: 4
//输出: "1211"
public class count_and_say {
    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(36));
    }

    static class Solution {
        public String countAndSay(int n) {
            StringBuilder result = new StringBuilder();
            StringBuilder temp = new StringBuilder("1");
            for (int i = 0; i < n - 1; i++) {
                int count = 1;
                for (int j = 0; j < temp.length(); j++) {
                    //重复数字，记录重复个数count，不进行计数
                    if (temp.length() > j + 1 && temp.charAt(j) == temp.charAt(j + 1)) {
                        count++;
                    } else {
                        //进行计数，并重置count
                        result.append(count).append(temp.charAt(j));
                        count = 1;
                    }
                }
                temp = result;
                result = new StringBuilder();
            }
            return temp.toString();
        }
    }
}
