package bilibili;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//https://www.nowcoder.com/question/next?pid=20725618&qid=643389&tid=32450275
//输入一个正整数数组，将它们连接起来排成一个数，输出能排出的所有数字中最小的一个。
//输入描述:
//一行输入，数组中的数字用逗号隔开。例如：
//输入为：
//32,231
//则表示数组{32, 231}
//输出描述:
//直接输出最小数字即可，如示例题目中，输出为：
//23132
//输入例子1:
//32,231
//输出例子1:
//23132
public class array_into_the_smallest_number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] str = s.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(str));
        list.sort((o1, o2) -> {
            for (int i = 0; i < o1.length() || i < o2.length(); i++) {
                char c1 = i >= o1.length() ? o1.charAt(i - 1) : o1.charAt(i);
                char c2 = i >= o2.length() ? o2.charAt(i - 1) : o2.charAt(i);
                if (c1 > c2) {
                    return 1;
                } else if (c1 < c2) {
                    return -1;
                }
            }
            return 0;
        });
        StringBuilder result = new StringBuilder();
        for (String s1 : list) {
            result.append(s1);
        }
        System.out.println(result);
    }
}
