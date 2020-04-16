package CSNotes.���ű�;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ֲ���ʵ��������ű�
 * ʹ��һ��ƽ�����飬һ���洢��һ���洢ֵ��
 * ���ֲ��ҵ�rank()����������Ҫ�������ڱ���ʱ�����ܹ�֪���ü���λ�ã��������ڱ���ʱ����Ҳ��֪���ںδ������¼���
 * ���ֲ��������ҪlogN+1�αȽϣ�ʹ�ö��ֲ���ʵ�ֵķ��ű�Ĳ��Ҳ�������Ҫ��ʱ������Ƕ�������ġ�
 * ���ǲ��������Ҫ�ƶ�����Ԫ�أ������Լ���ġ�
 */
public class BinarySearchOrderedST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int N = 0;

    public BinarySearchOrderedST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public int rank(Key key) {
        int l = 0, h = N - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            int cmp = key.compareTo(keys[m]);
            if (cmp == 0)
                return m;
            else if (cmp < 0)
                h = m - 1;
            else
                l = m + 1;
        }
        return l;
    }

    @Override
    public List<Key> keys(Key l, Key h) {
        int index = rank(l);
        List<Key> list = new ArrayList<>();
        while (keys[index].compareTo(h) <= 0) {
            list.add(keys[index]);
            index++;
        }
        return list;
    }

    @Override
    public void put(Key key, Value value) {
        int index = rank(key);
        //����ҵ��Ѿ����ڵĽڵ��Ϊkey���͸�������ڵ��ֵΪvalue
        if (index < N && keys[index].compareTo(key) == 0) {
            values[index] = value;
            return;
        }
        //�����������в����µĽڵ㣬��Ҫ�Ƚ�����λ��֮���Ԫ�ض�����ƶ�һ��λ��
        for (int j = N; j > index; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[index] = key;
        values[index] = value;
        N++;
    }

    @Override
    public Value get(Key key) {
        int index = rank(key);
        if (index < N && keys[index].compareTo(key) == 0)
            return values[index];
        return null;
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[N - 1];
    }
}