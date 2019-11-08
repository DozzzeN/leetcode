package Concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

//1195
//��дһ�����Դ� 1 �� n �������������ֵ��ַ����ĳ��򣬵��ǣ�
//	���������ֿ��Ա� 3 ��������� "fizz"��
//	���������ֿ��Ա� 5 ��������� "buzz"��
//	���������ֿ���ͬʱ�� 3 �� 5 ��������� "fizzbuzz"��
//���磬�� n = 15������� 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz��
//��������ôһ���ࣺ
//class FizzBuzz {
//  public FizzBuzz(int n) { ... }               // constructor
//  public void fizz(printFizz) { ... }          // only output "fizz"
//  public void buzz(printBuzz) { ... }          // only output "buzz"
//  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
//  public void number(printNumber) { ... }      // only output the numbers
//}
//����ʵ��һ�����ĸ��̵߳Ķ��̰߳�  FizzBuzz�� ͬһ�� FizzBuzz ʵ���ᱻ�����ĸ��߳�ʹ�ã�
//	�߳�A������ fizz() ���ж��Ƿ��ܱ� 3 ������������ԣ������ fizz��
//	�߳�B������ buzz() ���ж��Ƿ��ܱ� 5 ������������ԣ������ buzz��
//	�߳�C������ fizzbuzz() ���ж��Ƿ�ͬʱ�ܱ� 3 �� 5 ������������ԣ������ fizzbuzz��
//	�߳�D������ number() ��ʵ������Ȳ��ܱ� 3 ����Ҳ���ܱ� 5 ���������֡�
public class fizz_buzz_multithreaded {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(5);
        IntConsumer intConsumer = System.out::println;
        Thread fizz = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread buzz = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread fizzbuzz = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread number = new Thread(() -> {
            try {
                fizzBuzz.number(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        fizz.start();
        fizzbuzz.start();
        buzz.start();
        number.start();
    }

    static class FizzBuzz {
        private final Semaphore fizz = new Semaphore(0);
        private final Semaphore buzz = new Semaphore(0);
        private final Semaphore fizzbuzz = new Semaphore(0);
        private final Semaphore number = new Semaphore(0);
        private int n;
        private AtomicInteger cur = new AtomicInteger(1);

        public FizzBuzz(int n) {
            this.n = n;
        }

        public void fizz(Runnable printFizz) throws InterruptedException {
            while (true) {
                fizz.acquire();
                if (cur.get() > n) break;
                if (cur.get() % 3 == 0) {
                    printFizz.run();
                    number.release();
                }
            }
        }

        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (true) {
                buzz.acquire();
                if (cur.get() > n) break;
                if (cur.get() % 5 == 0) {
                    printBuzz.run();
                    number.release();
                }
            }
        }

        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (true) {
                fizzbuzz.acquire();
                if (cur.get() > n) break;
                if ((cur.get() % 3 == 0) && (cur.get() % 5 == 0)) {
                    printFizzBuzz.run();
                    number.release();
                }
            }
        }

        public void number(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                if ((cur.get() % 3 == 0) && (cur.get() % 5 == 0)) {
                    fizzbuzz.release();
                    number.acquire();
                } else {
                    if (cur.get() % 3 == 0) {
                        fizz.release();
                        number.acquire();
                    } else if (cur.get() % 5 == 0) {
                        buzz.release();
                        number.acquire();
                    } else {
                        printNumber.accept(cur.get());
                    }
                }
                cur.incrementAndGet();
                if (cur.get() > n) {
                    fizz.release();
                    buzz.release();
                    fizzbuzz.release();
                    break;
                }
            }
        }
    }
}
