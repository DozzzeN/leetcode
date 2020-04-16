package CSNotes.栈;

import java.util.Iterator;

public class ArrayStack<Item> implements MyStack<Item> {
    //栈元素数组，只能通过转型来创建泛型数组
    private Item[] data = (Item[]) new Object[1];

    //元素数量
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

        //避免对象游离
        //Java的垃圾收集策略是回收所有无法被访问的对象的内存。
        //pop()的实现中，被弹出的元素的引用仍然存在于数组中。
        //这个元素实际上就是个孤儿了，没有谁会再访问它，但Java编译器没法知道这一点，除非该引用被覆盖。
        //这种情况（保存一个不需要的对象的引用）成为游离。
        //在这里，避免对象游离很简单，只需将被弹出的数组元素的值设为null即可，
        //这将覆盖无用的引用，并使系统在使用完被弹出的元素后回收它的内存。
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
     * 调整数组大小，使得栈具有伸缩性
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
        //返回逆序遍历的迭代器
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
