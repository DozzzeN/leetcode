package HUAWEI;

import java.util.Scanner;

//https://www.nowcoder.com/question/next?pid=1088888&qid=36827&tid=32401872
//写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
//输入描述:
//输入一个十六进制的数值字符串。
//输出描述:
//输出该数值的十进制字符串。
//输入例子1:
//0xA
//输出例子1:
//10
public class hex_conversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(solution(scanner.nextLine()));
        }
    }

    public static int solution(String input) {
        int result = 0;
        if (input == null || input.length() == 0 || (input.charAt(0) != '0' && input.charAt(1) != 'x')) {
            return result;
        }
        for (int i = input.length() - 1, mul = 1; i > 1; i--, mul *= 16) {
            char c = input.charAt(i);
            if (c <= 'F' && c >= 'A') {
                result += (input.charAt(i) - 'A' + 10) * mul;
            } else {
                result += (input.charAt(i) - '0') * mul;
            }
        }
        return result;
    }

    public static int solution2(String input) {
        return Integer.decode(input);
    }
}
