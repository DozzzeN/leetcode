package CSNotes.����;

/**
 * ����ĳ���ڵ��ֵ���Ǵ��ڵ������ӽڵ��ֵ�����Ҷ���һ����ȫ��������
 * �ѿ�������������ʾ��������Ϊ������ȫ������������ȫ�����������׾ʹ洢�������С�
 * λ��k�Ľڵ�ĸ��ڵ�λ��Ϊk/2�������������ӽڵ��λ�÷ֱ�Ϊ2k��2k+1�����ﲻʹ����������Ϊ0��λ�ã���Ϊ�˸������������ڵ��λ�ù�ϵ��
 */
public class Heap<T extends Comparable<T>> {
    private T[] heap;
    private int N = 0;

    public Heap(int maxN) {
        this.heap = (T[]) new Comparable[maxN + 1];//�����1��ʼ
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private void swap(int i, int j) {
        T t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    /**
     * �ڶ��У���һ���ڵ�ȸ��ڵ����ô��Ҫ������������ڵ㡣
     * �����󻹿��ܱ����µĸ��ڵ�������Ҫ���ϵؽ��бȽϺͽ��������������ֲ�����Ϊ�ϸ���
     */
    private void swim(int k) {
        //k=1�Ǹ��ڵ�
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * ���Ƶأ���һ���ڵ���ӽڵ�����С��Ҳ��Ҫ���ϵ����½��бȽϺͽ��������������ֲ�����Ϊ�³���
     * һ���ڵ�����������ӽڵ㣬Ӧ���������ӽڵ�������Ǹ��ڵ���н�����
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;//����
            if (j < N && less(j, j + 1))
                j++;
            if (!less(k, j))
                break;//���轻��
            swap(k, j);
            k = j;
        }
    }

    /**
     * ����Ԫ�طŵ�����ĩβ��Ȼ���ϸ������ʵ�λ�á�
     */
    public void insert(T v) {
        heap[++N] = v;
        swim(N);
    }

    /**
     * �����鶥��ɾ������Ԫ�أ�������������һ��Ԫ�طŵ����ˣ��������Ԫ���³������ʵ�λ�á�
     */
    public T delMax() {
        T max = heap[1];
        swap(1, N--);
        heap[N + 1] = null;
        sink(1);
        return max;
    }
}
