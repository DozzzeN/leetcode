package Tencent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//https://www.nowcoder.com/question/next?pid=21283868&qid=830863&tid=32436460
//小Q在进行一场竞技游戏,这场游戏的胜负关键就在于能否能争夺一条长度为L的河道,即可以看作是[0,L]的一条数轴。
//这款竞技游戏当中有n个可以提供视野的道具-真视守卫,第i个真视守卫能够覆盖区间[xi,yi]。现在小Q想知道至少用几个真视守卫就可以覆盖整段河道。
//输入描述:
//输入包括n+1行。
//第一行包括两个正整数n和L(1<=n<=105,1<=L<=109)
//接下来的n行,每行两个正整数xi,yi(0<=xi<=yi<=109),表示第i个真视守卫覆盖的区间。
//输出描述:
//一个整数，表示最少需要的真视守卫数量, 如果无解, 输出-1。
//输入例子1:
//4 6
//3 6
//2 4
//0 2
//4 7
//输出例子1:
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
