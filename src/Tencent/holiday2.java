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
//��̬�滮
public class holiday2 {
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
        int[] f1 = new int[n + 1];//���һ����Ϣ�����Ĺ���/��������
        int[] f2 = new int[n + 1];//���һ�칤�������Ĺ���/��������
        int[] f3 = new int[n + 1];//���һ�콡�����Ĺ���/��������
        for (int i = 1; i <= n; i++) {
            f1[i] = Math.max(f1[i - 1], Math.max(f2[i - 1], f3[i - 1]));
            if (gongzuo[i - 1] == 1) {
                f2[i] = Math.max(f1[i - 1], f3[i - 1]) + 1;
            }
            if (jianshen[i - 1] == 1) {
                f3[i] = Math.max(f1[i - 1], f2[i - 1]) + 1;
            }
        }
        System.out.println(n - Math.max(f1[n], Math.max(f2[n], f3[n])));
    }
}
