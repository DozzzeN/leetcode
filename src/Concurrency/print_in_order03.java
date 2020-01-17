package Concurrency;

//1114
//�����ṩ��һ���ࣺ
//public class Foo {
//  public void one() { print("one"); }
//  public void two() { print("two"); }
//  public void three() { print("three"); }
//}
//������ͬ���߳̽��Ṳ��һ�� Foo ʵ����
//	�߳� A ������� one() ����
//	�߳� B ������� two() ����
//	�߳� C ������� three() ����
//������޸ĳ�����ȷ�� two() ������ one() ����֮��ִ�У�three() ������ two() ����֮��ִ�С�
//ʾ�� 1:
//����: [1,2,3]
//���: "onetwothree"
//����:
//�������̻߳ᱻ�첽������
//���� [1,2,3] ��ʾ�߳� A ������� one() �������߳� B ������� two() �������߳� C ������� three() ������
//��ȷ������� "onetwothree"��
//ʾ�� 2:
//����: [1,3,2]
//���: "onetwothree"
//����:
//���� [1,3,2] ��ʾ�߳� A ������� one() �������߳� B ������� three() �������߳� C ������� two() ������
//��ȷ������� "onetwothree"��
//ע��:
//���������е������ƺ���ʾ��˳�򣬵������ǲ�����֤�߳��ڲ���ϵͳ�еĵ���˳��
//�㿴���������ʽ��Ҫ��Ϊ��ȷ�����Ե�ȫ���ԡ�
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

    //ʹ����
    static class Foo {
        private int flag = 0;

        public Foo() {

        }

        //�൱�ڶ�����Foo����Ҳ���Դ���һ��final����lock����lock���󲢵���lock��wait��notify
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
