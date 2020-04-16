package Tencent;

import java.util.Scanner;

//https://www.nowcoder.com/test/question/c27561e5b7e0441493adb9a54071888d?pid=21283868&tid=32413754
//小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，
//对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，例如字符串ABCABCABC将会被压缩为[3|ABC]，
//现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
//输入描述:
//输入第一行包含一个字符串s，代表压缩后的字符串。
//S的长度<=1000;
//S仅包含大写字母、[、]、|;
//解压后的字符串长度不超过100000;
//压缩递归层数不超过10层;
//输出描述:
//输出一个字符串，代表解压后的字符串。
//输入例子1:
//HG[3|B[2|CA]]F
//输出例子1:
//HGBCACABCACABCACAF
//例子说明1:
//HG[3|B[2|CA]]F->HG[3|BCACA]F->HGBCACABCACABCACAF
public class compression_algorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(solution(scanner.nextLine()));
        }
    }

    public static String solution(String input) {
        if (input.indexOf('[') == -1 && input.indexOf(']') == -1 && input.indexOf('|') == -1) return input;
        StringBuilder result = new StringBuilder();
        int end = input.indexOf(']');
        int start = 0;
        for (int i = end - 1; i >= 0; i--) {
            if (input.charAt(i) == '[') {
                start = i;
                break;
            }
        }
        result.append(input, 0, start);
        StringBuilder countStr = new StringBuilder();
        for (int i = start; i < end; i++) {
            if (Character.isDigit(input.charAt(i))) {
                countStr.append(input.charAt(i));
            }
        }
        int count = Integer.parseInt(countStr.toString());
        for (int i = 0; i < count; i++) {
            result.append(input, start + 2 + countStr.length(), end);
        }
        result.append(input, end + 1, input.length());
        return solution(result.toString());
    }
}
