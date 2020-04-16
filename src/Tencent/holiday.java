package Tencent;

import java.util.Scanner;

//https://www.nowcoder.com/question/next?pid=21283868&qid=830862&tid=32436460
//����ҵ�����㣬��˾��СQ���� n ��ļ٣���Ϊ�������СQ�������ڼ����й���������������Ϣ��
//���и���ֵ�ϰ�ߣ������������칤���������ֻ�е���˾Ӫҵʱ��СQ����ȥ������ֻ�е�����Ӫҵʱ��СQ����ȥ����СQһ��ֻ�ܸ�һ���¡�
//���������й�˾��������Ӫҵ�������СQ������Ҫ��Ϣ���졣
//
//��������:
//��һ��һ������n(1<=n<=100000) ��ʾ�ż�����
//�ڶ��� n ���� ÿ����Ϊ0��1,�� i ������ʾ��˾�ڵ� i ���Ƿ�Ӫҵ
//������ n ���� ÿ����Ϊ0��1,�� i ������ʾ�����ڵ� i ���Ƿ�Ӫҵ
//��1ΪӪҵ 0Ϊ��Ӫҵ��
//�������:
//һ����������ʾСQ��Ϣ����������
//��������1:
//4
//1 1 0 0
//0 1 1 0
//�������1:
//2
//����˵��1:
//СQ�����ڵ�һ�칤�����ڶ��������콡��СQ������Ϣ2��

/**
 * 4
 * 1 1 0 1
 * 1 0 1 1
 */
//���ݳ�ʱ
public class holiday {
    static int result = 0;
    static int max = 0;
    static int lastGongzuo = -2;
    static int lastJianshen = -2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] gongzuo = new int[n];
        int[] jianshen = new int[n];
        for (int i = 0; i < n; i++) {
            gongzuo[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            jianshen[i] = scanner.nextInt();
        }
        solution(gongzuo, jianshen, 0);
        System.out.println(n - max);
    }

    public static void solution(int[] gongzuo, int[] jianshen, int cur) {
        if (cur == gongzuo.length) {
            max = Math.max(max, result);
            return;
        }
        if (cur - lastGongzuo > 1) {
            int temp = lastGongzuo;
            lastGongzuo = cur;
            result += gongzuo[cur];
            solution(gongzuo, jianshen, cur + 1);
            result -= gongzuo[cur];
            lastGongzuo = temp;
        }
        if (cur - lastJianshen > 1) {
            int temp = lastJianshen;
            lastJianshen = cur;
            result += jianshen[cur];
            solution(gongzuo, jianshen, cur + 1);
            result -= jianshen[cur];
            lastJianshen = temp;
        }
        //��Ϣ
        solution(gongzuo, jianshen, cur + 1);
    }
}
