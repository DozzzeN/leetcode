package bilibili;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//https://www.nowcoder.com/question/next?pid=20725618&qid=643389&tid=32450275
//����һ�����������飬���������������ų�һ������������ų���������������С��һ����
//��������:
//һ�����룬�����е������ö��Ÿ��������磺
//����Ϊ��
//32,231
//���ʾ����{32, 231}
//�������:
//ֱ�������С���ּ��ɣ���ʾ����Ŀ�У����Ϊ��
//23132
//��������1:
//32,231
//�������1:
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
