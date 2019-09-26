package Math;

import java.util.LinkedHashMap;
import java.util.Map;
//13
//例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
//通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//	I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
//	X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
//	C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
//示例 1:
//输入: "III"
//输出: 3
//示例 2:
//输入: "IV"
//输出: 4
//示例 3:
//输入: "IX"
//输出: 9
//示例 4:
//输入: "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
//示例 5:
//输入: "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4.
public class roman_to_integer {
    public static void main(String[] args) {
        String input = "LVIII";
        System.out.println(new roman_to_integer.Solution().romanToInt(input));

    }

    static class Solution {
        public int romanToInt(String s) {
            Map<Character, Integer> charSet = new LinkedHashMap<>();
            charSet.put('I', 1);//
            charSet.put('V', 5);
            charSet.put('X', 10);//
            charSet.put('L', 50);
            charSet.put('C', 100);//
            charSet.put('D', 500);
            charSet.put('M', 1000);

            char[] romanChar = s.toCharArray();
            int result = 0;
            for (int i = 0; i < romanChar.length; i++) {
                boolean flag = false;
                for (char roman : charSet.keySet()) {
                    if (romanChar[i] == roman) {
                        result += charSet.get(roman);
                    }

                    if (i == 0 || flag == true) {
                        continue;
                    }

                    switch (romanChar[i]) {
                        case 'V': {
                            if (romanChar[i - 1] == 'I') result -= 2;
                            flag = true;
                            break;
                        }
                        case 'X': {
                            if (romanChar[i - 1] == 'I') result -= 2;
                            flag = true;
                            break;
                        }
                        case 'L': {
                            if (romanChar[i - 1] == 'X') result -= 20;
                            flag = true;
                            break;
                        }
                        case 'C': {
                            if (romanChar[i - 1] == 'X') result -= 20;
                            flag = true;
                            break;
                        }
                        case 'D': {
                            if (romanChar[i - 1] == 'C') result -= 200;
                            flag = true;
                            break;
                        }
                        case 'M': {
                            if (romanChar[i - 1] == 'C') result -= 200;
                            flag = true;
                            break;
                        }
                    }
                }
            }

            if (result < 1 || result > 3999) {
                result = -1;
            }

            return result;
        }
    }
}
