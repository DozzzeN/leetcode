package Graph;

import java.util.Arrays;

public class BellmanFord {
    //����https://blog.csdn.net/anlian523/article/details/80953767��ʵ��
    public static void main(String[] args) {
        long[][] edge = new long[][]{
                {0, -1, 4, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 0, 3, 2, 2},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, -5, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 1, Integer.MAX_VALUE, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -3, 0}
        };
        new BellmanFord.Solution().BellmanFord(edge, 5, 0);
    }

    //Bellman-Ford�㷨 �����ڽӾ���
    static class Solution {
        public void BellmanFord(long[][] edge, int n, int original) {
            long[] dis = new long[n];
            int[] pre = new int[n];//����õ������·���е���һ�����㣬����·����ԭ
            Arrays.fill(dis, Integer.MAX_VALUE);
            Arrays.fill(pre, -1);
            dis[original] = 0;//Դ��㵽�������Ϊ0
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dis[j] > edge[i][j] + dis[i]) {
                        dis[j] = edge[i][j] + dis[i];
                        pre[j] = i;
                    }
                }
                System.out.print("dis " + Arrays.toString(dis));
                System.out.println(" pre " + Arrays.toString(pre));
            }
            //���˸�Ȩ��ʱ����ѭ��һ�δ�0��3��·���ֻ��һ����Ϊ���˸�Ȩ��һȦ
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (dis[j] > edge[i][j] + dis[i]) {
//                        dis[j] = edge[i][j] + dis[i];
//                        pre[j] = i;
//                    }
//                }
//                System.out.print("dis " + Arrays.toString(dis));
//                System.out.println(" pre " + Arrays.toString(pre));
//            }
            boolean flag = false;//�Ƿ��и�Ȩ��
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dis[j] > dis[i] + edge[i][j]) {
                        //�����˱�ʾ�и�Ȩ��
                        flag = true;
                        break;
                    }
                }
            }
            System.out.println(flag);
        }
    }
}
