package Concurrency;

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
public class print_foobar_alternately {
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
        private int n;
        private int flag = 1;

        public FooBar(int n) {
            this.n = n;
        }

        public synchronized void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (flag != 1) {
                    wait();
                }
                printFoo.run();
                flag = 2;
                notifyAll();
            }
        }

        public synchronized void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (flag != 2) {
                    wait();
                }
                printBar.run();
                flag = 1;
                notifyAll();
            }
        }
    }
}
