package Heap;

//POJ 2431
//你需要驾驶一辆卡车行驶L单位距离。最开始时,卡车上有P单位的汽油。卡车每开1单位
//距离需要消耗1单位的汽油。如果在途中车上的汽油耗尽，卡车就无法继续前行，因而无法
//到达终点。在途中一共有N个加油站。第i个加油站在距离起点Ai单位距离的地方，最多
//可以给卡车加Bi单位汽油。假设卡车的燃料箱的容量是无限大的，无论加多少油都没有问
//题。那么请问卡车是否能到达终点?如果可以，最少需要加多少次油?如果可以到达终点，
//输出最少的加油次数，否则输出-1。

//输入
//N=4，L=25，P=10
//A={10，14，20，21}
//B={10，5，2，4}

import java.util.PriorityQueue;
import java.util.Queue;

//输出
//2(在第1个和第2个加油站加油)
public class expedition {
    //在经过加油站时，往优先队列里加入Bi。
    //当燃料箱空了时，
    //●如果优先队列也是空的，则无法到达终点。
    //●否则取出优先队列中的最大元素，并用来给卡车加油。
    int N = 4, L = 25, P = 10;
    //把终点也看做加油站
    int[] A = new int[]{10, 14, 20, 21, L};
    int[] B = new int[]{10, 5, 2, 4, 0};

    public static void main(String[] args) {
        new expedition().solve();
    }

    public void solve() {
        Queue<Integer> queue = new PriorityQueue<>();

        //ans:加油次数，pos:现在所在位置，tank:油箱中汽油的量
        int ans = 0, pos = 0, tank = P;
        for (int i = 0; i < N; i++) {
            //接下来前进的距离
            int d = A[i] - pos;
            //一直加油直到油量足够到下一个加油站
            while (tank < d) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                    return;
                }
                tank += queue.poll();
                ans++;
            }
            tank -= d;
            pos = A[i];
            queue.add(B[i]);
        }
        System.out.println(ans);
    }
}
