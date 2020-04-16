package Tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.nowcoder.com/question/next?pid=21283868&qid=830860&tid=32413754
//СQ����ĩ��ʱ�������С�����������й�֣�һ�����н����кܶ��¥������n����¥�ų�һ�С�
//СQ�ӵ�һ��һֱ�ߵ������һ����СQ������û�м�����ô���¥����������֪������ÿ��¥��λ�ô��ܿ������ٶ�¥�أ�
//����ǰ���¥�ĸ߶ȴ��ڵ��ں����¥ʱ�������¥������ס��
//��������:
//�����һ�н�����һ������n������¥�Ķ�������������һ�н�����n������wi(1<=i<=n)������ÿһ��¥�ĸ߶ȡ�
//1<=n<=100000;
//1<=wi<=100000;
//�������:
//���һ�У������ո�ָ��n������vi���ֱ����СQ�ڵ�i��¥ʱ�ܿ�����¥��������
//��������1:
//6
//5 3 8 3 2 5
//�������1:
//3 3 5 4 4 4
//����˵��1:
//��СQ����λ��3ʱ����������ǰ����λ��2,1����¥����󿴵�λ��4,6����¥�����ϵ�3��¥�����ɿ���5��¥��
//��СQ����λ��4ʱ����������ǰ����λ��3����¥����󿴵�λ��5,6����¥�����ϵ�4��¥�����ɿ���4��¥��
public class go_shopping {
    //���Ӷ�̫��
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            String inputStr = scanner.nextLine();
            System.out.println(solution(inputStr, n));
        }
    }

    public static String solution(String inputStr, int n) {
        List<Integer> input = new ArrayList<>();
        String[] arr = inputStr.split("\\s+");
        for (int i = 0; i < n; i++) {
            input.add(Integer.parseInt(arr[i]));
        }
        StringBuilder result = new StringBuilder();
        int count;
        for (int i = 0; i < input.size(); i++) {
            count = 1;
            int left = 0, right = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (j == i - 1) {
                    count++;
                    left = input.get(j);
                    continue;
                }
                if (input.get(j) > left) {
                    count++;
                    left = input.get(j);
                }
            }
            for (int j = i + 1; j < input.size(); j++) {
                if (j == i + 1) {
                    count++;
                    right = input.get(j);
                    continue;
                }
                if (input.get(j) > right) {
                    count++;
                    right = input.get(j);
                }
            }
            result.append(count).append(" ");
        }
        return result.toString();
    }
}
