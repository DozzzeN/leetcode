package Tencent;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class compression_algorithm02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.next();
        Pattern pattern = Pattern.compile("\\[(\\d+)\\|(\\w+)]");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            int num = Integer.parseInt(matcher.group(1));
            StringBuilder chs = new StringBuilder();
            for (int i = 0; i < num; i++) {
                chs.append(matcher.group(2));
            }
            line = matcher.replaceFirst(chs.toString());
            matcher = pattern.matcher(line);
        }
        System.out.println(line);
    }
}
