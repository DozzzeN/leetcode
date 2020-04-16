package CSNotes.���ű�;

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
     * ɾ������Ӧ�����Ҳ��������ڵļ�ֵ�����²���ɢ�б��С�
     */
    public void delete(Key key) {
        int i = hash(key);
        while (keys[i] != null && !key.equals(keys[i]))
            i = (i + 1) % M;

        //�����ڣ�ֱ�ӷ���
        if (keys[i] == null) return;
        keys[i] = null;
        values[i] = null;

        //��֮�������ļ�ֵ�����²���
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
     * ����̽�ⷨ�ĳɱ�ȡ����������Ŀ�ĳ��ȣ�������ĿҲ�о۴ء����۴غܳ�ʱ���ڲ��ҺͲ���ʱҲ��Ҫ���кܶ��̽�⡣
     * ��=N/M���Ѧ���Ϊʹ���ʡ�����֤��������С��1/2ʱ̽���Ԥ�ƴ���ֻ��1.5��2.5֮�䡣
     * Ϊ�˱�֤ɢ�б�����ܣ�Ӧ����������Ĵ�С��ʹ�æ���[1/4,1/2]֮�䡣
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