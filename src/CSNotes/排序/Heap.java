package CSNotes.排序;

/**
 * 堆中某个节点的值总是大于等于其子节点的值，并且堆是一颗完全二叉树。
 * 堆可以用数组来表示，这是因为堆是完全二叉树，而完全二叉树很容易就存储在数组中。
 * 位置k的节点的父节点位置为k/2，而它的两个子节点的位置分别为2k和2k+1。这里不使用数组索引为0的位置，是为了更清晰地描述节点的位置关系。
 */
public class Heap<T extends Comparable<T>> {
    private T[] heap;
    private int N = 0;

    public Heap(int maxN) {
        this.heap = (T[]) new Comparable[maxN + 1];//数组从1开始
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
     * 在堆中，当一个节点比父节点大，那么需要交换这个两个节点。
     * 交换后还可能比它新的父节点大，因此需要不断地进行比较和交换操作，把这种操作称为上浮。
     */
    private void swim(int k) {
        //k=1是根节点
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 类似地，当一个节点比子节点来得小，也需要不断地向下进行比较和交换操作，把这种操作称为下沉。
     * 一个节点如果有两个子节点，应当与两个子节点中最大那个节点进行交换。
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;//左孩子
            if (j < N && less(j, j + 1))
                j++;
            if (!less(k, j))
                break;//无需交换
            swap(k, j);
            k = j;
        }
    }

    /**
     * 将新元素放到数组末尾，然后上浮到合适的位置。
     */
    public void insert(T v) {
        heap[++N] = v;
        swim(N);
    }

    /**
     * 从数组顶端删除最大的元素，并将数组的最后一个元素放到顶端，并让这个元素下沉到合适的位置。
     */
    public T delMax() {
        T max = heap[1];
        swap(1, N--);
        heap[N + 1] = null;
        sink(1);
        return max;
    }
}
