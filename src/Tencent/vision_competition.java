package Tencent;

import java.util.HashMap;
import java.util.Map;
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

//为何会越界
public class vision_competition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int[] map = new int[l];
        Map<Integer, Integer> input = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (input.containsKey(x)) {
                input.put(x, Math.max(y, input.get(x)));
            } else {
                input.put(x, y);
            }
        }
        for (Map.Entry<Integer, Integer> entries : input.entrySet()) {
            if (entries.getKey() < 0) {
                map[0] = entries.getValue();
            } else {
                map[entries.getKey()] = entries.getValue();
            }
        }
        if (map[0] == 0) System.out.println(-1);
        int max = map[0];
        int result = 1;
        int cur = map[0];
        for (int i = 1; i < map.length && cur < l; i++) {
            if (i <= cur) {
                max = Math.max(max, map[i]);
            } else {
                if (i > max) {
                    System.out.println(-1);
                    return;
                } else {
                    cur = max;
                    max = map[i];
                    result++;
                }
            }
        }
        if (cur != max) {
            cur = max;
            result++;
        }
        if (cur < l) System.out.println(-1);
        else System.out.println(result);
    }
}
