package DFS;

import UnionFindSet.UnionFindSet;

import java.util.ArrayList;
import java.util.List;

//547
//������ N ��ѧ����������Щ�������ѣ���Щ���ǡ����ǵ���������Ǵ����ԡ������֪ A �� B �����ѣ�B �� C �����ѣ���ô���ǿ�����Ϊ A Ҳ�� C �����ѡ���ν������Ȧ����ָ�������ѵļ��ϡ�
//����һ�� N * N �ľ��� M����ʾ�༶��ѧ��֮������ѹ�ϵ�����M[i][j] = 1����ʾ��֪�� i ���� j ��ѧ����Ϊ���ѹ�ϵ������Ϊ��֪����������������ѧ���е���֪������Ȧ������
//ʾ�� 1:
//����:
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//���: 2
//˵������֪ѧ��0��ѧ��1��Ϊ���ѣ�������һ������Ȧ��
//��2��ѧ���Լ���һ������Ȧ�����Է���2��
//ʾ�� 2:
//����:
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//���: 1
//˵������֪ѧ��0��ѧ��1��Ϊ���ѣ�ѧ��1��ѧ��2��Ϊ���ѣ�����ѧ��0��ѧ��2Ҳ�����ѣ���������������һ������Ȧ������1��
//ע�⣺
//	N ��[1,200]�ķ�Χ�ڡ�
//	��������ѧ������M[i][i] = 1��
//	�����M[i][j] = 1������M[j][i] = 1��
public class friend_circles {
    public static void main(String[] args) {
        System.out.println(new friend_circles.Solution().findCircleNum(new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        }));
    }

    //ʱ�临�Ӷȣ�O(n^3)���������Ϊn^2,���鼯�����n
    static class Solution {
        public int findCircleNum(int[][] M) {
            if (M == null || M.length == 0 || M[0].length == 0) return 0;
            int[] visited = new int[M.length];//��ע��Χ���Ľڵ㣬��ֹ��ѭ��
            int result = 0;
            for (int i = 0; i < M.length; i++) {
                if (visited[i] == 0) {
                    dfs(M, visited, i);
                    result++;
                }
            }
            return result;
        }

        public void dfs(int[][] M, int[] visited, int i) {
            for (int j = 0; j < M.length; j++) {
                if (visited[j] == 0 && M[i][j] == 1) {
                    visited[j] = 1;
                    dfs(M, visited, j);
                }
            }
        }
    }
}
