package UnionFindSet;

//POJ 1182
//有N只动物，分别编号为1,2..,N。所有动物都属于A,B,C中的其中一种。已知A吃B、
//B吃C、C吃A。按顺序给出下面的两种信息共K条。
//●第一种:x和y属于同一种类。
//●第二种:x吃y。
//然而这些信息有可能会出错。有可能有的信息和之前给出的信息矛盾，也有的信息可能给出
//的x和y不在1,2,...,N的范围内。求在K条信息中有多少条是不正确的。计算过程中，我
//们将忽视诸如此类的错误信息。

//输入
//N=100，K=7
//信息有下面7条
//第一种，x=101，y=1
//第二种，x=1，y=2
//第二种，x=2，y=3
//第二种，x=3，y=3
//第一种，x=1，y=3
//第二种，x=3，y=1
//第一种，x=5，y=5

//输出
//3 (第1、4、5条是错误的信息)
public class 食物链 {
    //对于每只动物创建3个元素i-A,i-B,i-C,并用这3xN个元素建立并查集。这个并查集维护如下
    //信息:
    //■i-x表示属于种类x
    //■并查集里的每一个组表示组内所有元素代表的情况都同时发生或不发生
    int N = 100, K = 7;
    int[] T = new int[]{1, 2, 2, 2, 1, 2, 1};//信息的类型
    int[] X = new int[]{101, 1, 2, 3, 1, 3, 5};
    int[] Y = new int[]{1, 2, 3, 3, 3, 1, 5};

    public static void main(String[] args) {
        new 食物链().solve();
    }

    public void solve() {
        //元素x，x+N，x+2*N分别代表x-A，x-B，x-C
        UnionFindSet02 set = new UnionFindSet02();
        set.init(N * 3);

        int ans = 0;
        for (int i = 0; i < K; i++) {
            int t = T[i];
            int x = X[i] - 1, y = Y[i] - 1;//把输入变为从0到N-1的范围

            //不正确的编号
            if (x < 0 || N <= x || y < 0 || N <= y) {
                ans++;
                continue;
            }

            if (t == 1) {
                //x-A和y-B或y-C同一类
                if (set.same(x, y + N) || set.same(x, y + 2 * N)) {
                    ans++;
                } else {
                    set.unite(x, y);
                    set.unite(x + N, y + N);
                    set.unite(x + 2 * N, y + 2 * N);
                }
            } else {
                //x吃y：x-A和y-A或y-C同一类
                if (set.same(x, y) || set.same(x, y + 2 * N)) {
                    ans++;
                } else {
                    set.unite(x, y + N);
                    set.unite(x + N, y + 2 * N);
                    set.unite(x + 2 * N, y + N);
                }
            }
        }
        System.out.println(ans);
    }
}
