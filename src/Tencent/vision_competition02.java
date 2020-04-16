package Tencent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//https://www.nowcoder.com/question/next?pid=21283868&qid=830863&tid=32436460
//СQ�ڽ���һ��������Ϸ,�ⳡ��Ϸ��ʤ���ؼ��������ܷ�������һ������ΪL�ĺӵ�,�����Կ�����[0,L]��һ�����ᡣ
//������Ϸ������n�������ṩ��Ұ�ĵ���-��������,��i�����������ܹ���������[xi,yi]������СQ��֪�������ü������������Ϳ��Ը������κӵ���
//��������:
//�������n+1�С�
//��һ�а�������������n��L(1<=n<=105,1<=L<=109)
//��������n��,ÿ������������xi,yi(0<=xi<=yi<=109),��ʾ��i�������������ǵ����䡣
//�������:
//һ����������ʾ������Ҫ��������������, ����޽�, ���-1��
//��������1:
//4 6
//3 6
//2 4
//0 2
//4 7
//�������1:
//3

/**
 * 10 28
 * 5 24
 * 8 27
 * 9 19
 * 3 17
 * 13 18
 * 9 25
 * 19 29
 * 12 15
 * 25 29
 * 0 6
 */
public class vision_competition02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();
        int[][] guard = new int[n][2];
        for (int i = 0; i < guard.length; ++i) {
            guard[i][0] = in.nextInt();
            guard[i][1] = in.nextInt();
        }
        Arrays.sort(guard, Comparator.comparingInt(a -> a[0]));
        if (guard[0][0] > 0) System.out.println(-1);
        int end = guard[0][1];
        int cnt = 1;
        int max = end;
        for (int i = 1; i < guard.length; ++i) {
            if (guard[i][0] <= end) {
                max = Math.max(max, guard[i][1]);
            } else {
                if (guard[i][0] > max) System.out.println(-1);
                else {
                    end = max;
                    max = guard[i][1];
                    cnt++;
                }
            }
            if (end >= l) {
                System.out.println(cnt);
                return;
            }
        }
        if (end != max) {
            end = max;
            cnt++;
        }
        if (end >= l) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }
}
