package Concurrency;

//1114
//我们提供了一个类：
//public class Foo {
//  public void one() { print("one"); }
//  public void two() { print("two"); }
//  public void three() { print("three"); }
//}
//三个不同的线程将会共用一个 Foo 实例。
//	线程 A 将会调用 one() 方法
//	线程 B 将会调用 two() 方法
//	线程 C 将会调用 three() 方法
//请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
//示例 1:
//输入: [1,2,3]
//输出: "onetwothree"
//解释:
//有三个线程会被异步启动。
//输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
//正确的输出是 "onetwothree"。
//示例 2:
//输入: [1,3,2]
//输出: "onetwothree"
//解释:
//输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
//正确的输出是 "onetwothree"。
//注意:
//尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
//你看到的输入格式主要是为了确保测试的全面性。
public class print_in_order03 {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Thread t1 = new Thread(() -> {
            try {
                foo.first(() -> System.out.println(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.println(2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.println(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        t3.start();
        t1.start();
    }

    //使用锁
    static class Foo {
        private int flag = 0;

        public Foo() {

        }

        //相当于都锁了Foo对象，也可以创建一个final对象lock，锁lock对象并调用lock的wait和notify
        public synchronized void first(Runnable printFirst) throws InterruptedException {
            while (flag != 0) {
                wait();
            }
            printFirst.run();
            flag = 1;
            notifyAll();
        }

        public synchronized void second(Runnable printSecond) throws InterruptedException {
            while (flag != 1) {
                wait();
            }
            printSecond.run();
            flag = 2;
            notifyAll();
        }

        public synchronized void third(Runnable printThird) throws InterruptedException {
            while (flag != 2) {
                wait();
            }
            printThird.run();
            flag = 0;
            notifyAll();
        }
    }
}
