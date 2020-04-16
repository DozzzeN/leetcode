package Tencent;

import java.util.Scanner;

//https://www.nowcoder.com/test/question/c27561e5b7e0441493adb9a54071888d?pid=21283868&tid=32413754
//СQ��Ҫ���������ѷ���һ�������ַ����������������ַ����Ĺ��ڳ��ˣ�����СQ������һ��ѹ���㷨���ַ������ظ��Ĳ��ֽ�����ѹ����
//�����ַ�����������m����ͬ�ַ���S����ѹ��Ϊ[m|S](mΪһ��������1<=m<=100)�������ַ���ABCABCABC���ᱻѹ��Ϊ[3|ABC]��
//����СQ��ͬѧ�յ���СQ���͹������ַ��������ܰ��������н�ѹ��ô��
//��������:
//�����һ�а���һ���ַ���s������ѹ������ַ�����
//S�ĳ���<=1000;
//S��������д��ĸ��[��]��|;
//��ѹ����ַ������Ȳ�����100000;
//ѹ���ݹ����������10��;
//�������:
//���һ���ַ����������ѹ����ַ�����
//��������1:
//HG[3|B[2|CA]]F
//�������1:
//HGBCACABCACABCACAF
//����˵��1:
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
