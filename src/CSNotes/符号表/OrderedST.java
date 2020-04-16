package CSNotes.符号表;

import java.util.List;

/**
 * 有序符号表主要指支持 min()、max() 等根据键的大小关系来实现的操作。
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