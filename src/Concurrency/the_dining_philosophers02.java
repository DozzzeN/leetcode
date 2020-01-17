package Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//1226
//5 ����Ĭ���Ե���ѧ��Χ����Բ��ǰ��ÿ����ǰһ�����档���ӷ�����ѧ��֮��������ϡ���5 ����ѧ�ң�5 �����ӣ�
//���е���ѧ�Ҷ�ֻ����˼���ͽ���������Ϊ�佻�档��ѧ��ֻ��ͬʱ�õ���ߺ��ұߵĲ��Ӳ��ܳԵ��棬��ͬһ��������ͬһʱ��ֻ�ܱ�һ����ѧ��ʹ�á�ÿ����ѧ�ҳ��������Ҫ�Ѳ��ӷŻ������Թ�������ѧ�ҳ��档ֻҪ����������ѧ�ҿ���������߻����ұߵĲ��ӣ�����û��ͬʱ�õ����Ҳ���ʱ���ܽ�ʳ��
//�����������û�����ƣ���ѧ��Ҳ�����ԣ�����Ҫ���ǳԲ��Ե��¡�
//���һ�����͹��򣨲����㷨��ʹ��ÿ����ѧ�Ҷ����ᰤ����Ҳ����˵����û����֪������ʲôʱ����Զ�����˼��������£�ÿ����ѧ�Ҷ������ڳԷ���˼��֮��һֱ������ȥ��
//����������ͼƬ����ά���ٿ� wikipedia.org
//��ѧ�Ҵ� 0 �� 4 �� ˳ʱ�� ��š���ʵ�ֺ��� void wantsToEat(philosopher, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork)��
//	philosopher ��ѧ�ҵı�š�
//	pickLeftFork �� pickRightFork ��ʾ������߻��ұߵĲ��ӡ�
//	eat ��ʾ���档
//	putLeftFork �� pickRightFork ��ʾ������߻��ұߵĲ��ӡ�
//	������ѧ�Ҳ����ڳ������������ɶʱ����棬����˼���������û�ж�Ӧ�Ļص���
//���� 5 ���̣߳�ÿ��������һ����ѧ�ң�����ʹ�����ͬһ��������ģ��������̡������һ�ε��ý���֮ǰ�����ܻ�Ϊͬһ����ѧ�Ҷ�ε��øú�����
//ʾ����
//���룺n = 1
//�����[[4,2,1],[4,1,1],[0,1,1],[2,2,1],[2,1,1],[2,0,3],[2,1,2],[2,2,2],[4,0,3],[4,1,2],[0,2,1],[4,2,2],[3,2,1],[3,1,1],[0,0,3],[0,1,2],[0,2,2],[1,2,1],[1,1,1],[3,0,3],[3,1,2],[3,2,2],[1,0,3],[1,1,2],[1,2,2]]
//����:
//n ��ʾÿ����ѧ����Ҫ���͵Ĵ�����
//������������˲��ӵĿ��ƺͽ��͵ĵ��ã����ĸ�ʽ���£�
//output[i] = [a, b, c] (3������)
//- a ��ѧ�ұ�š�
//- b ָ�����ӣ�{1 : ���, 2 : �ұ�}.
//- c ָ����Ϊ��{1 : ����, 2 : ����, 3 : ����}��
//�� [4,2,1] ��ʾ 4 ����ѧ���������ұߵĲ��ӡ�
//��ʾ��
//	1 <= n <= 60
public class the_dining_philosophers02 {
    class DiningPhilosophers {
        private Lock[] locks = new Lock[5];

        public DiningPhilosophers() {
            for (int i = 0; i < 5; i++) {
                locks[i] = new ReentrantLock();
            }
        }

        //�ƻ������뱣�������������Ѿ�����������һ����Դ������������µ���Դ���󣬶�����Դ�ѱ���������ռ�У���ʱ������̱������������Լ��ѻ�õ���Դ���ֲ��š�
        //����1���ٽ�����ʵ��1����ѧ�ҡ�ͬʱ����������2�Ѳ��ӵ�Ч����
        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            int leftFork = philosopher;
            int rightFork = (philosopher + 1) % 5;
            synchronized (this) {
                locks[leftFork].lock();
                locks[rightFork].lock();
                pickLeftFork.run();
                pickRightFork.run();
            }
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            locks[leftFork].unlock();
            locks[rightFork].unlock();
            //��С��������
            //}
        }
    }
}
