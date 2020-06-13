package Heap;

//POJ 2431
//����Ҫ��ʻһ��������ʻL��λ���롣�ʼʱ,��������P��λ�����͡�����ÿ��1��λ
//������Ҫ����1��λ�����͡������;�г��ϵ����ͺľ����������޷�����ǰ�У�����޷�
//�����յ㡣��;��һ����N������վ����i������վ�ھ������Ai��λ����ĵط������
//���Ը�������Bi��λ���͡����迨����ȼ��������������޴�ģ����ۼӶ����Ͷ�û����
//�⡣��ô���ʿ����Ƿ��ܵ����յ�?������ԣ�������Ҫ�Ӷ��ٴ���?������Ե����յ㣬
//������ٵļ��ʹ������������-1��

//����
//N=4��L=25��P=10
//A={10��14��20��21}
//B={10��5��2��4}

import java.util.PriorityQueue;
import java.util.Queue;

//���
//2(�ڵ�1���͵�2������վ����)
public class expedition {
    //�ھ�������վʱ�������ȶ��������Bi��
    //��ȼ�������ʱ��
    //��������ȶ���Ҳ�ǿյģ����޷������յ㡣
    //�����ȡ�����ȶ����е����Ԫ�أ����������������͡�
    int N = 4, L = 25, P = 10;
    //���յ�Ҳ��������վ
    int[] A = new int[]{10, 14, 20, 21, L};
    int[] B = new int[]{10, 5, 2, 4, 0};

    public static void main(String[] args) {
        new expedition().solve();
    }

    public void solve() {
        Queue<Integer> queue = new PriorityQueue<>();

        //ans:���ʹ�����pos:��������λ�ã�tank:���������͵���
        int ans = 0, pos = 0, tank = P;
        for (int i = 0; i < N; i++) {
            //������ǰ���ľ���
            int d = A[i] - pos;
            //һֱ����ֱ�������㹻����һ������վ
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
