package bilibili;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//https://www.nowcoder.com/question/next?pid=20725618&qid=643390&tid=32450275
//��ΪN����Ʒ�����ǵ�����w�ֱ���w1,w2,...,wn�����ǵļ�ֵv�ֱ���v1,v2,...,vn��
//ÿ����Ʒ�������ҽ���һ�������ڸ��������ΪM�ı������󱳰���װ�����Ʒ���еļ�ֵ����ܺͣ�
//��������:
//��Ʒ����N=5��
//����w�ֱ���2 2 6 5 4
//��ֵv�ֱ���6 3 5 4 6
//��������ΪM=10
//�������:
//��������Ʒ����ܺ�Ϊ15
//��������1:
//5
//10
//2 2 6 5 4
//6 3 5 4 6
//�������1:
//15

/**
 * 4
 * 8
 * 3 2 1 1
 * 4 2 3 4
 */
public class backpack_problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//5
        int M = scanner.nextInt();//10
        int[] input = new int[2 * N];
        for (int i = 0; i < 2 * N; i++) {
            input[i] = scanner.nextInt();
        }
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0});
        for (int i = 1; i < N + 1; i++) {
            int[] ele = new int[]{input[i - 1], input[N + i - 1]};
            list.add(ele);
        }
        list.sort((o1, o2) -> {
            if (o1[0] > o2[0]) return 1;
            else if (o1[0] < o2[0]) return -1;
            else {
                if (o1[1] > o2[1]) return 1;
                else if (o1[1] < o2[1]) return -1;
            }
            return 0;
        });
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                if (list.get(i)[0] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - list.get(i)[0]] + list.get(i)[1]);
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(input));
        }
        System.out.println(dp[N][M]);
    }
}
