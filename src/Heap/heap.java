package Heap;

//用数组表示二叉堆
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
            //父亲节点的编号
            int p = (i - 1) / 2;

            //如果没有大小颠倒则退出
            if (heap[p] <= x) break;

            //与父节点互换
            heap[i] = heap[p];
            i = p;
        }
        heap[i] = x;
    }

    public int pop() {
        //最小值
        int ret = heap[0];
        //要提到根的数值
        int x = heap[--sz];

        //从根开始向下交换
        int i = 0;
        while (i * 2 + 1 < sz) {
            //比较儿子的值
            int a = i * 2 + 1, b = i * 2 + 2;
            if (b < sz && heap[b] < heap[a]) {
                a = b;
            }
            //没有大小颠倒
            if (heap[a] >= x) break;
            heap[i] = heap[a];
            i = a;
        }
        heap[i] = x;
        return ret;
    }
}
