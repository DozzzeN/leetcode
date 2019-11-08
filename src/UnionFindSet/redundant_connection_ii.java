package UnionFindSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//685
//�ڱ������У��и���ָ������������������ͼ������ֻ��һ�����ڵ㣬���������ڵ㶼�Ǹø��ڵ�ĺ�̡�ÿһ���ڵ�ֻ��һ�����ڵ㣬���˸��ڵ�û�и��ڵ㡣
//����һ������ͼ����ͼ��һ������N���ڵ� (�ڵ�ֵ���ظ�1, 2, ..., N) ������һ�����ӵı߹��ɡ����ӵıߵ��������������1��N�м䣬�������ӵı߲����������Ѵ��ڵıߡ�
//���ͼ��һ���Ա���ɵĶ�ά���顣 ÿһ���� ��Ԫ����һ�� [u, v]�����Ա�ʾ����ͼ�����Ӷ��� u and v�Ͷ���ıߣ����и��ڵ�u���ӽڵ�v��һ�����ڵ㡣
//����һ����ɾ���ıߣ�ʹ��ʣ�µ�ͼ����N���ڵ���и��������ж���𰸣������������ڸ�����ά����Ĵ𰸡�
//ʾ�� 1:
//����: [[1,2], [1,3], [2,3]]
//���: [2,3]
//����: ����������ͼ����:
//  1
// / \
//v   v
//2-->3
//ʾ�� 2:
//����: [[1,2], [2,3], [3,4], [4,1], [1,5]]
//���: [4,1]
//����: ����������ͼ����:
//5 <- 1 -> 2
//     ^    |
//     |    v
//     4 <- 3
//ע��:
//	��ά�����С����3��1000��Χ�ڡ�
//	��ά�����е�ÿ��������1��N֮�䣬���� N �Ƕ�ά����Ĵ�С��
public class redundant_connection_ii {
    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}
        };
        System.out.println(Arrays.toString(new redundant_connection_ii.Solution().findRedundantDirectedConnection(edges)));
    }

    //����˼·���������������1.����ͼ�л���û����ȴ���1�Ľڵ㣬ɾ�����һ���γɻ��ı�
    //2.����ͼû�л�������ȴ���1�Ľڵ㣬ɾ�����һ��ʹ����ȴ���1�ı�
    //3.����ͼ���л�������ȴ���1�Ľڵ㣬����̽��2�ı�ɾ����ʣ�µı߻᲻��ɻ������ɻ���2�ı�Ϊ���󣬷���ɾ����ȴ���1�ڵ�ĵ�һ����

    //�����д���
    static class Solution {
        public int[] findRedundantDirectedConnection(int[][] edges) {
            UnionFindSet unionFindSet = new UnionFindSet(edges.length);
            List<Integer> node = new ArrayList<>();
            int[] dupNode = new int[2];
            for (int i = 0; i < edges.length; i++) {
                if (!node.contains(edges[i][1])) {
                    node.add(edges[i][1]);
                } else {
                    dupNode[1] = edges[i][1];
                }
            }
            for (int i = edges.length - 1; i > 0; i--) {
                if (edges[i][1] == dupNode[1]) {
                    dupNode[0] = edges[i][0];
                    break;
                }
            }
            if (dupNode[0] != 0) return dupNode;
            else for (int i = 0; i < edges.length; i++) {
                unionFindSet.Union(edges[i][0], edges[i][1]);
            }
            for (int i = 0; i < edges.length; i++) {
                if (unionFindSet.Find(i) != i) {
                    dupNode[1] = edges[i][0];
                }
            }
            for (int i = edges.length - 1; i > 0; i--) {
                if (edges[i][1] == dupNode[1]) {
                    dupNode[0] = edges[i][0];
                    break;
                }
            }
            return dupNode;
        }
    }
}
