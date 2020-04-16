package Tencent;

import java.util.Scanner;
import java.util.Stack;

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
public class go_shopping02 {
    //ʹ�õ���ջ���浱ǰ�ĵ�������/�ݼ�¥��߶ȵ�����
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            //��ʱ��ջ���Ⱦ��Ǵ˴��������󿴵���¥�����
            result[i] = stack.size();
            while (!stack.isEmpty() && input[i] >= stack.peek()) {
                stack.pop();
            }
            stack.push(input[i]);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            result[i] += (1 + stack.size());
            while (!stack.isEmpty() && input[i] >= stack.peek()) {
                stack.pop();
            }
            stack.push(input[i]);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
