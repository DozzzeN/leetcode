package Heap;

//�������ʾ�����
public class heap {
    int N = 10;
    int[] heap = new int[N];
    int sz = 0;

    public static void main(String[] args) {
        Heap.heap heap = new heap();
        heap.push(1);
        heap.push(2);
        heap.push(4);
        heap.push(7);
        heap.push(8);
        heap.push(5);
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        heap.push(3);
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
    }

    public void push(int x) {
        int i = sz++;
        while (i > 0) {
            //���׽ڵ�ı��
            int p = (i - 1) / 2;

            //���û�д�С�ߵ����˳�
            if (heap[p] <= x) break;

            //�븸�ڵ㻥��
            heap[i] = heap[p];
            i = p;
        }
        heap[i] = x;
    }

    public int pop() {
        //��Сֵ
        int ret = heap[0];
        //Ҫ�ᵽ������ֵ
        int x = heap[--sz];

        //�Ӹ���ʼ���½���
        int i = 0;
        while (i * 2 + 1 < sz) {
            //�Ƚ϶��ӵ�ֵ
            int a = i * 2 + 1, b = i * 2 + 2;
            if (b < sz && heap[b] < heap[a]) {
                a = b;
            }
            //û�д�С�ߵ�
            if (heap[a] >= x) break;
            heap[i] = heap[a];
            i = a;
        }
        heap[i] = x;
        return ret;
    }
}
