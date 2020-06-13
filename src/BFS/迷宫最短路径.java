package BFS;

//����һ����СΪNxM���Թ����Թ���ͨ����ǽ����ɣ�ÿһ���������ڽӵ����������ĸ�
//��ͨ���ƶ������������㵽�յ��������С��������ע�⣬����ٶ������һ�������ƶ����յ㡣

import java.util.LinkedList;
import java.util.Queue;

//���룺
//N=10��M=10 (�Թ�����ͼ��ʾ��'#'�� '.'��'S'��'G'�ֱ��ʾǽ�ڡ�ͨ���������յ�)
//#S######.#
//......#..#
//.#.##.##.#
//.#........
//##.##.####
//....#....#
//.#######.#
//....#.....
//.####.###.
//....#...G#

//�����22
public class �Թ����·�� {
    int N = 10, M = 10;
    char[][] maze = new char[][]{
            {'#', 'S', '#', '#', '#', '#', '#', '#', '.', '#'},
            {'.', '.', '.', '.', '.', '.', '#', '.', '.', '#'},
            {'.', '#', '.', '#', '#', '.', '#', '#', '.', '#'},
            {'.', '#', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'#', '#', '.', '#', '#', '.', '#', '#', '#', '#'},
            {'.', '.', '.', '.', '#', '.', '.', '.', '.', '#'},
            {'.', '#', '#', '#', '#', '#', '#', '#', '.', '#'},
            {'.', '.', '.', '.', '#', '.', '.', '.', '.', '.'},
            {'.', '#', '#', '#', '#', '.', '#', '#', '#', '.'},
            {'.', '.', '.', '.', '#', '.', '.', '.', 'G', '#'},
    };

    int sx = 0, sy = 1;//���
    int gx = 9, gy = 8;//�յ�

    //�ĸ����������
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};

    //������λ�õ���̾�������
    int[][] d = new int[N][M];

    public static void main(String[] args) {
        new �Թ����·��().solve();
    }

    public int bfs() {
        Queue<P> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                d[i][j] = Integer.MIN_VALUE;
            }
        }
        que.add(new P(sx, sy));
        d[sx][sy] = 0;

        while (!que.isEmpty()) {
            P p = que.poll();
            if (p.x == gx && p.y == gy) break;

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M && maze[nx][ny] != '#' && d[nx][ny] == Integer.MIN_VALUE) {
                    que.add(new P(nx, ny));
                    d[nx][ny] = d[p.x][p.y] + 1;
                }
            }
        }

        return d[gx][gy];
    }

    public void solve() {
        int res = bfs();
        System.out.println(res);
    }

    public static class P {
        public int x;
        public int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
