package DFS;


//��������a1��a2��...��an���ж��Ƿ���Դ���ѡ����������ʹ���ǵĺ�ǡ��Ϊk��
//����n=4
//a=1,2,4,7
//k=13
//�����Yes (13=2+4+7)
public class ���ֺ� {
    int[] a = new int[]{1, 2, 4, 7};
    int n = 4;
    int k = 13;

    public static void main(String[] args) {
        ���ֺ� solution = new ���ֺ�();
        solution.solve();
    }

    public void solve() {
        if (dfs(0, 0)) System.out.println("Yes");
        else System.out.println("No");
    }

    //ǰi����֮��λsum
    public boolean dfs(int i, int sum) {
        if (i == n) return sum == k;
        //����a[i]���
        if (dfs(i + 1, sum)) return true;
        //��a[i]�����
        return dfs(i + 1, sum + a[i]);
    }
}
