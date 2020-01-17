package Concurrency;

import java.util.concurrent.CountDownLatch;

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
public class print_in_order02 {
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

    //ʹ�ñ���
    static class Foo {
        private final CountDownLatch first_second = new CountDownLatch(1);
        private final CountDownLatch second_third = new CountDownLatch(1);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            first_second.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            first_second.await();
            printSecond.run();
            second_third.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            second_third.await();
            printThird.run();
        }
    }
}
