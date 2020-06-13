package Greedy;

//有n项工作，每项工作分别在si时间开始，在ti时间结束。对于每项工作，你都可以选择参与与否。
//如果选择了参与，那么自始至终都必须全程参与。此外，参与工作的时间段不能重叠(即使是开始的瞬间和结束的瞬间的重叠也是不允许的)。

//输入
//n=5，s={1，2，4，6，8}，t={3，5，7，9，10}

import java.util.Arrays;
import java.util.Comparator;

//输出
//3(选取工作1、3、5)
public class 区间调度 {
    int N = 5;
    int[] S = {1, 2, 4, 6, 8};
    int[] T = {3, 5, 7, 9, 10};
    Pair[] itv = new Pair[N];

    public static void main(String[] args) {
        new 区间调度().solve();
    }

    public void solve() {
        //为了让结束时间早的工作排在前面
        for (int i = 0; i < N; i++) {
            itv[i] = new Pair(S[i], T[i]);
        }
        Arrays.sort(itv, Comparator.comparingInt(o -> o.y));

        int ans = 0, t = 0;
        for (int i = 0; i < N; i++) {
            if (t < itv[i].x) {
                t = itv[i].y;
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
