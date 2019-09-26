package UnionFindSet;

public class number_of_islands03 {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new Solution().numIslands(grid));
        for (char[] chars : grid) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    //���鼯
    //������ά���񣬽���ֱ��ˮƽ���ڵ�½�����ᡣ���գ����ز��鼯���ݽṹ���������ֵ�������
    static class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int nr = grid.length;
            int nc = grid[0].length;
            int num_islands = 0;
            UnionFind uf = new UnionFind(grid);
            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == '1') {
                        grid[r][c] = '0';
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            uf.union(r * nc + c, (r - 1) * nc + c);
                        }
                        if (r + 1 < nr && grid[r + 1][c] == '1') {
                            uf.union(r * nc + c, (r + 1) * nc + c);
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            uf.union(r * nc + c, r * nc + c - 1);
                        }
                        if (c + 1 < nc && grid[r][c + 1] == '1') {
                            uf.union(r * nc + c, r * nc + c + 1);
                        }
                    }
                }
            }

            return uf.getCount();
        }

        class UnionFind {
            int count; // # of connected components
            int[] parent;
            int[] rank;

            public UnionFind(char[][] grid) { // for problem 200
                count = 0;
                int m = grid.length;
                int n = grid[0].length;
                parent = new int[m * n];
                rank = new int[m * n];
                for (int i = 0; i < m; ++i) {
                    for (int j = 0; j < n; ++j) {
                        if (grid[i][j] == '1') {
                            //�����1��λ�ڸ��ڵ�
                            parent[i * n + j] = i * n + j;
                            //���ĸ�������
                            ++count;
                        }
                        rank[i * n + j] = 0;
                    }
                }
            }

            public int find(int i) { // path compression
                //�ҵ����ڵ�
                if (parent[i] != i) parent[i] = find(parent[i]);
                return parent[i];
            }

            public void union(int x, int y) { // union with rank
                //�ϲ��ڵ�
                int rootx = find(x);
                int rooty = find(y);
                if (rootx != rooty) {
                    if (rank[rootx] > rank[rooty]) {
                        parent[rooty] = rootx;
                    } else if (rank[rootx] < rank[rooty]) {
                        parent[rootx] = rooty;
                    } else {
                        parent[rooty] = rootx;
                        rank[rootx] += 1;
                    }
                    //�ϲ��Ժ󵺵ĸ�������
                    --count;
                }
            }

            public int getCount() {
                return count;
            }
        }
    }
}