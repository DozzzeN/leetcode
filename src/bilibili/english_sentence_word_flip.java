package bilibili;

import java.util.Scanner;

//https://www.nowcoder.com/question/next?pid=20725618&qid=643419&tid=32450275
//ԭ�ط�ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣Ҫ�󣺿ռ临�Ӷ�O(1)��ʱ�临�Ӷ�O(n)��
//��������:
//Ӣ�ľ����е�����һ���ո��������Ϊ������������ź���ͨ��ĸһ������
//�������:
//��ת֮���Ӣ�ľ��ӣ��������ַ���˳�򲻱䣬��һ���ո������
//��������1:
//I am a student.
//�������1:
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
