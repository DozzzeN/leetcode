package Concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

//1195
//编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
//	如果这个数字可以被 3 整除，输出 "fizz"。
//	如果这个数字可以被 5 整除，输出 "buzz"。
//	如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
//例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
//假设有这么一个类：
//class FizzBuzz {
//  public FizzBuzz(int n) { ... }               // constructor
//  public void fizz(printFizz) { ... }          // only output "fizz"
//  public void buzz(printBuzz) { ... }          // only output "buzz"
//  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
//  public void number(printNumber) { ... }      // only output the numbers
//}
//请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
//	线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
//	线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
//	线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
//	线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
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
