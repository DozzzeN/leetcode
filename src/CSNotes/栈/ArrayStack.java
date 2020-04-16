package CSNotes.ջ;

import java.util.Iterator;

public class ArrayStack<Item> implements MyStack<Item> {
    //ջԪ�����飬ֻ��ͨ��ת����������������
    private Item[] data = (Item[]) new Object[1];

    //Ԫ������
    private int N = 0;

    @Override
    public MyStack<Item> push(Item item) {
        check();
        data[N++] = item;
        return this;
    }

    @Override
    public Item pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("stack is empty");
        }

        Item item = data[--N];

        check();

        //�����������
        //Java�������ռ������ǻ��������޷������ʵĶ�����ڴ档
        //pop()��ʵ���У���������Ԫ�ص�������Ȼ�����������С�
        //���Ԫ��ʵ���Ͼ��Ǹ��¶��ˣ�û��˭���ٷ���������Java������û��֪����һ�㣬���Ǹ����ñ����ǡ�
        //�������������һ������Ҫ�Ķ�������ã���Ϊ���롣
        //����������������ܼ򵥣�ֻ�轫������������Ԫ�ص�ֵ��Ϊnull���ɣ�
        //�⽫�������õ����ã���ʹϵͳ��ʹ���걻������Ԫ�غ���������ڴ档
        data[N] = null;

        return item;
    }

    private void check() {
        if (N >= data.length) {
            resize(2 * data.length);

        } else if (N > 0 && N <= data.length / 4) {
            resize(data.length / 2);
        }
    }

    /**
     * ���������С��ʹ��ջ����������
     */
    private void resize(int size) {
        Item[] tmp = (Item[]) new Object[size];

        if (N >= 0) System.arraycopy(data, 0, tmp, 0, N);

        data = tmp;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        //������������ĵ�����
        return new Iterator<>() {
            private int i = N;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public Item next() {
                return data[--i];
            }
        };
    }
}
