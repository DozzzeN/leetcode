package UnionFindSet;

//POJ 1182
//��Nֻ����ֱ���Ϊ1,2..,N�����ж��ﶼ����A,B,C�е�����һ�֡���֪A��B��
//B��C��C��A����˳����������������Ϣ��K����
//���һ��:x��y����ͬһ���ࡣ
//��ڶ���:x��y��
//Ȼ����Щ��Ϣ�п��ܻ�����п����е���Ϣ��֮ǰ��������Ϣì�ܣ�Ҳ�е���Ϣ���ܸ���
//��x��y����1,2,...,N�ķ�Χ�ڡ�����K����Ϣ���ж������ǲ���ȷ�ġ���������У���
//�ǽ������������Ĵ�����Ϣ��

//����
//N=100��K=7
//��Ϣ������7��
//��һ�֣�x=101��y=1
//�ڶ��֣�x=1��y=2
//�ڶ��֣�x=2��y=3
//�ڶ��֣�x=3��y=3
//��һ�֣�x=1��y=3
//�ڶ��֣�x=3��y=1
//��һ�֣�x=5��y=5

//���
//3 (��1��4��5���Ǵ������Ϣ)
public class ʳ���� {
    //����ÿֻ���ﴴ��3��Ԫ��i-A,i-B,i-C,������3xN��Ԫ�ؽ������鼯��������鼯ά������
    //��Ϣ:
    //��i-x��ʾ��������x
    //�����鼯���ÿһ�����ʾ��������Ԫ�ش���������ͬʱ�����򲻷���
    int N = 100, K = 7;
    int[] T = new int[]{1, 2, 2, 2, 1, 2, 1};//��Ϣ������
    int[] X = new int[]{101, 1, 2, 3, 1, 3, 5};
    int[] Y = new int[]{1, 2, 3, 3, 3, 1, 5};

    public static void main(String[] args) {
        new ʳ����().solve();
    }

    public void solve() {
        //Ԫ��x��x+N��x+2*N�ֱ����x-A��x-B��x-C
        UnionFindSet02 set = new UnionFindSet02();
        set.init(N * 3);

        int ans = 0;
        for (int i = 0; i < K; i++) {
            int t = T[i];
            int x = X[i] - 1, y = Y[i] - 1;//�������Ϊ��0��N-1�ķ�Χ

            //����ȷ�ı��
            if (x < 0 || N <= x || y < 0 || N <= y) {
                ans++;
                continue;
            }

            if (t == 1) {
                //x-A��y-B��y-Cͬһ��
                if (set.same(x, y + N) || set.same(x, y + 2 * N)) {
                    ans++;
                } else {
                    set.unite(x, y);
                    set.unite(x + N, y + N);
                    set.unite(x + 2 * N, y + 2 * N);
                }
            } else {
                //x��y��x-A��y-A��y-Cͬһ��
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
