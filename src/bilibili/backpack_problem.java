package bilibili;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//https://www.nowcoder.com/question/next?pid=20725618&qid=643390&tid=32450275
//有为N件物品，它们的重量w分别是w1,w2,...,wn，它们的价值v分别是v1,v2,...,vn，
//每件物品数量有且仅有一个，现在给你个承重为M的背包，求背包里装入的物品具有的价值最大总和？
//输入描述:
//物品数量N=5件
//重量w分别是2 2 6 5 4
//价值v分别是6 3 5 4 6
//背包承重为M=10
//输出描述:
//背包内物品最大总和为15
//输入例子1:
//5
//10
//2 2 6 5 4
//6 3 5 4 6
//输出例子1:
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
