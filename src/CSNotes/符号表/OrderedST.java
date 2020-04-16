package CSNotes.���ű�;

import java.util.List;

/**
 * ������ű���Ҫָ֧�� min()��max() �ȸ��ݼ��Ĵ�С��ϵ��ʵ�ֵĲ�����
 */
public interface OrderedST<Key extends Comparable<Key>, Value> {
    int size();

    void put(Key key, Value value);

    Value get(Key key);

    Key min();

    Key max();

    int rank(Key key);

    List<Key> keys(Key l, Key h);
}