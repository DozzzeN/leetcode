package Concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

//1117
//�����������̣߳��� oxygen ���� hydrogen�����Ŀ������֯�������߳�������ˮ���ӡ�
//����һ�����ϣ�barrier��ʹ��ÿ���̱߳���Ⱥ�ֱ��һ������ˮ�����ܹ�������������
//������̻߳ᱻ�ֱ���� releaseHydrogen �� releaseOxygen ��������������ͻ�����ϡ�
//��Щ�߳�Ӧ����������ͻ�����ϲ���������ϲ���һ��ˮ���ӡ�
//����뱣֤����һ��ˮ���������̵߳Ľ�ϱ��뷢������һ��ˮ���Ӳ���֮ǰ��
//���仰˵:
//	���һ�����̵߳�������ʱû�����̵߳��������Ⱥ�ֱ���������̵߳��
//	���һ�����̵߳�������ʱû�������̵߳��������Ⱥ�ֱ��һ�����̺߳���һ�����̵߳��
//��д������Щ�����������⡢���߳�ͬ�����롣
//ʾ�� 1:
//����: "HOH"
//���: "HHO"
//����: "HOH" �� "OHH" ��Ȼ������Ч�⡣
//ʾ�� 2:
//����: "OOHHHH"
//���: "HHOHHO"
//����: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" �� "OHHOHH" ��Ȼ������Ч�⡣
//��������:
//	�����ַ������ܳ������� 3n, 1 �� n �� 50��
//	�����ַ����е� ��H�� ���������� 2n��
//	�����ַ����е� ��O�� ���������� n��
public class building_h2o02 {
    public static void main(String[] args) throws InterruptedException {
        //���������ַ���
        String test = "OHOOHOHHHHOHHOHHHH";

        //���ɽ���ַ���
        StringBuffer result = new StringBuffer();

        //ע�⣺������Runnable�����޷������̣߳�����������������߳�����
        //����������������
        Runnable releaseHydrogen = () -> result.append("H");

        //����������������
        Runnable releaseOxygen = () -> result.append("O");

        //�����߳�����
        Thread[] threads = new Thread[test.length()];

        H2O h2o = new H2O();
        for (int i = 0; i < test.length(); ++i) {
            Thread thread = null;
            //���ݻ�õ��ַ�������Ӧ�������������߳�
            if (test.charAt(i) == 'O') {
                thread = new OGenerator(h2o, releaseOxygen);
            } else if (test.charAt(i) == 'H') {
                thread = new HGenerator(h2o, releaseHydrogen);
            }
            //��ʼ�߳�
            thread.start();
            //���浽�߳�����
            threads[i] = thread;
        }

        //���������߳�ִ����
        for (Thread thread : threads) {
            thread.join();
        }

        //��������
        for (int i = 0; i < result.length(); i++) {
            if (i % 3 == 0) {
                System.out.print(" ");
            }
            System.out.print(result.charAt(i));
        }
    }

    //���������߳�
    static class HGenerator extends Thread {
        H2O h2o;
        Runnable releaseHydrogen;

        public HGenerator(H2O h2o, Runnable releaseHydrogen) {
            this.h2o = h2o;
            this.releaseHydrogen = releaseHydrogen;
        }

        @Override
        public void run() {
            try {
                h2o.hydrogen(releaseHydrogen);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //���������߳�
    static class OGenerator extends Thread {
        H2O h2o;
        Runnable releaseOxygen;

        public OGenerator(H2O h2o, Runnable releaseOxygen) {
            this.h2o = h2o;
            this.releaseOxygen = releaseOxygen;
        }

        @Override
        public void run() {
            try {
                h2o.oxygen(releaseOxygen);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class H2O {
        private final Semaphore H = new Semaphore(2);
        private final Semaphore O = new Semaphore(1);
        private volatile AtomicInteger Hcount = new AtomicInteger(0);

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            H.acquire();
            releaseHydrogen.run();
            //û��2��Hʱ�Ϳ����ͷ�O����
            if (Hcount.incrementAndGet() % 2 == 0) {
                O.release();
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            O.acquire();
            releaseOxygen.run();
            H.release(2);
        }
    }
}

