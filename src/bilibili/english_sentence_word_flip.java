package bilibili;

import java.util.Scanner;

//https://www.nowcoder.com/question/next?pid=20725618&qid=643419&tid=32450275
//原地翻转句子中单词的顺序，但单词内字符的顺序不变。要求：空间复杂度O(1)，时间复杂度O(n)。
//输入描述:
//英文句子中单词以一个空格符隔开。为简单起见，标点符号和普通字母一样处理。
//输出描述:
//翻转之后的英文句子，单词内字符的顺序不变，以一个空格隔开。
//输入例子1:
//I am a student.
//输出例子1:
//student. a am I
public class english_sentence_word_flip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        input = input.reverse().append(" ");
        int start = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                for (int j = start, k = 0; k < (i - j) / 2; k++) {
                    char c = input.charAt(j + k);
                    input.setCharAt(j + k, input.charAt(i - k - 1));
                    input.setCharAt(i - k - 1, c);
                }
                start = i + 1;
            }
        }
        System.out.println(input.toString());
    }
}
