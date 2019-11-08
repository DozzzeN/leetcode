package Concurrency;

import java.util.concurrent.Semaphore;

//1115
//�����ṩһ���ࣺ
//class FooBar {
//  public void foo() {
//    for (int i = 0; i < n; i++) {
//      print("foo");
//    }
//  }
//  public void bar() {
//    for (int i = 0; i < n; i++) {
//      print("bar");
//    }
//  }
//}
//������ͬ���߳̽��Ṳ��һ�� FooBar ʵ��������һ���߳̽������ foo() ��������һ���߳̽������ bar() ������
//������޸ĳ�����ȷ�� "foobar" ����� n �Ρ�
//ʾ�� 1:
//����: n = 1
//���: "foobar"
//����: �����������̱߳��첽����������һ������ foo() ����, ��һ������ bar() ������"foobar" �������һ�Ρ�
//ʾ�� 2:
//����: n = 2
//���: "foobarfoobar"
//����: "foobar" ����������Ρ�
public class print_foobar_alternately02 {
    public static void main(String[] args) {
        FooBar fooBar = new FooBar(10);
        Thread foo = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread bar = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        foo.start();
        bar.start();
    }

    static class FooBar {
        private final Semaphore foo = new Semaphore(1);
        private final Semaphore bar = new Semaphore(0);
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                foo.acquire();
                printFoo.run();
                bar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                bar.acquire();
                printBar.run();
                foo.release();
            }
        }
    }
}
