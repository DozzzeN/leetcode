package UnionFindSet;

import java.util.Arrays;

//684
//�ڱ�������, ��ָ����һ����ͨ���޻�������ͼ��
//����һ��ͼ����ͼ��һ������N���ڵ� (�ڵ�ֵ���ظ�1, 2, ..., N) ������һ�����ӵı߹��ɡ����ӵıߵ��������������1��N�м䣬�������ӵı߲����������Ѵ��ڵıߡ�
//���ͼ��һ���Ա���ɵĶ�ά���顣ÿһ���ߵ�Ԫ����һ��[u, v] ������ u < v����ʾ���Ӷ���u ��v������ͼ�ıߡ�
//����һ������ɾȥ�ıߣ�ʹ�ý��ͼ��һ������N���ڵ����������ж���𰸣��򷵻ض�ά�����������ֵıߡ��𰸱� [u, v] Ӧ������ͬ�ĸ�ʽ u < v��
//ʾ�� 1��
//����: [[1,2], [1,3], [2,3]]
//���: [2,3]
//����: ����������ͼΪ:
//  1
// / \
//2 - 3
//ʾ�� 2��
//����: [[1,2], [2,3], [3,4], [1,4], [1,5]]
//���: [1,4]
//����: ����������ͼΪ:
//5 - 1 - 2
//    |   |
//    4 - 3
//ע��:
//	����Ķ�ά�����С�� 3 �� 1000��
//	��ά�����е�������1��N֮�䣬����N����������Ĵ�С��
public class redundant_connection {
    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}
        };
        System.out.println(Arrays.toString(new redundant_connection.Solution().findRedundantConnection(edges)));
    }

    static class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            UnionFindSet unionFindSet = new UnionFindSet(edges.length);
            for (int i = 0; i < edges.length; i++) {
                if (unionFindSet.Find(edges[i][0]) != unionFindSet.Find(edges[i][1])) {
                    unionFindSet.Union(edges[i][0], edges[i][1]);
                } else {
                    return edges[i];
                }
            }
            return new int[1];
        }
    }
}
