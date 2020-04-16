package CSNotes.符号表;

public class LinearProbingHashST<Key, Value> implements UnorderedST<Key, Value> {
    private int N = 0;
    private int M = 16;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST() {
        init();
    }

    public LinearProbingHashST(int M) {
        this.M = M;
        init();
    }

    private void init() {
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public int size() {
        return N;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) return values[i];
        return null;
    }

    public void put(Key key, Value value) {
        resize();
        putInternal(key, value);
    }

    private void putInternal(Key key, Value value) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    /**
     * 删除操作应当将右侧所有相邻的键值对重新插入散列表中。
     */
    public void delete(Key key) {
        int i = hash(key);
        while (keys[i] != null && !key.equals(keys[i]))
            i = (i + 1) % M;

        //不存在，直接返回
        if (keys[i] == null) return;
        keys[i] = null;
        values[i] = null;

        //将之后相连的键值对重新插入
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            putInternal(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        resize();
    }

    /**
     * 线性探测法的成本取决于连续条目的长度，连续条目也叫聚簇。当聚簇很长时，在查找和插入时也需要进行很多次探测。
     * α=N/M，把α称为使用率。理论证明，当α小于1/2时探测的预计次数只在1.5到2.5之间。
     * 为了保证散列表的性能，应当调整数组的大小，使得α在[1/4,1/2]之间。
     */
    private void resize() {
        if (N >= M / 2)
            resize(2 * M);
        else if (N <= M / 8)
            resize(M / 2);
    }

    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t = new LinearProbingHashST<>(cap);
        for (int i = 0; i < M; i++)
            if (keys[i] != null) t.putInternal(keys[i], values[i]);

        keys = t.keys;
        values = t.values;
        M = t.M;
    }
}