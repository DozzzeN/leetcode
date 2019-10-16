package UnionFindSet;

import java.util.ArrayList;
import java.util.Arrays;
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
    //�Ƚ�����ֵΪ1��Ӧ����������벢�鼯��Ȼ���������鼯���е�Ԫ�أ��ҳ���ͬ�ĸ���
    static class Solution {
        public int findCircleNum(int[][] M) {
            if (M == null || M.length == 0 || M[0].length == 0) return 0;
            int n = M.length;
            UnionFindSet unionFindSet = new UnionFindSet(n - 1);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (M[i][j] == 1) {
                        unionFindSet.Union(i, j);
                    }
                }
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!list.contains(unionFindSet.Find(i))) {
                    list.add(unionFindSet.Find(i));
                }
            }
            return list.size();
        }
    }
}
