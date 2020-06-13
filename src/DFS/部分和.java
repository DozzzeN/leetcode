package DFS;


//给定整数a1、a2、...、an，判断是否可以从中选出若干数，使它们的和恰好为k。
//输入n=4
//a=1,2,4,7
//k=13
//输出：Yes (13=2+4+7)
public class 部分和 {
    int[] a = new int[]{1, 2, 4, 7};
    int n = 4;
    int k = 13;

    public static void main(String[] args) {
        部分和 solution = new 部分和();
        solution.solve();
    }

    public void solve() {
        if (dfs(0, 0)) System.out.println("Yes");
        else System.out.println("No");
    }

    //前i个数之和位sum
    public boolean dfs(int i, int sum) {
        if (i == n) return sum == k;
        //不加a[i]情况
        if (dfs(i + 1, sum)) return true;
        //加a[i]的情况
        return dfs(i + 1, sum + a[i]);
    }
}
