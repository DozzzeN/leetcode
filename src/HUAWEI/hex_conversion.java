package HUAWEI;

import java.util.Scanner;

//https://www.nowcoder.com/question/next?pid=1088888&qid=36827&tid=32401872
//д��һ�����򣬽���һ��ʮ�����Ƶ������������ֵ��ʮ���Ʊ�ʾ��������ͬʱ���� ��
//��������:
//����һ��ʮ�����Ƶ���ֵ�ַ�����
//�������:
//�������ֵ��ʮ�����ַ�����
//��������1:
//0xA
//�������1:
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
