package Concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

//1116
//��������ôһ���ࣺ
//class ZeroEvenOdd {
//  public ZeroEvenOdd(int n) { ... }      // ���캯��
//  public void zero(printNumber) { ... }  // ����ӡ�� 0
//  public void even(printNumber) { ... }  // ����ӡ�� ż��
//  public void odd(printNumber) { ... }   // ����ӡ�� ����
//}
//��ͬ��һ�� ZeroEvenOdd ��ʵ�����ᴫ�ݸ�������ͬ���̣߳�
//	�߳� A ������ zero()����ֻ��� 0 ��
//	�߳� B ������ even()����ֻ���ż����
//	�߳� C ������ odd()����ֻ���������
//ÿ���̶߳���һ�� printNumber ���������һ�����������޸ĸ����Ĵ���������������� 010203040506... ���������еĳ��ȱ���Ϊ 2n��
//ʾ�� 1��
//���룺n = 2
//�����"0102"
//˵���������߳��첽ִ�У�����һ������ zero()����һ���̵߳��� even()�����һ���̵߳���odd()����ȷ�����Ϊ "0102"��
//ʾ�� 2��
//���룺n = 5
//�����"0102030405"
public class print_zero_even_odd {
    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        IntConsumer intConsumer = System.out::println;
        Thread zero = new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread odd = new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread even = new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        zero.start();
        even.start();
        odd.start();
    }

    static class ZeroEvenOdd {
        private int n;
        private final Semaphore zero = new Semaphore(1);
        private final Semaphore even = new Semaphore(0);
        private final Semaphore odd = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                zero.acquire();
                printNumber.accept(0);
                if (i % 2 == 0) {
                    even.release();
                } else {
                    odd.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    even.acquire();
                    printNumber.accept(i);
                    zero.release();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 2 != 0) {
                    odd.acquire();
                    printNumber.accept(i);
                    zero.release();
                }
            }
        }
    }
}
