package BFS;

//给定一个大小为NxM的迷宫。迷宫由通道和墙壁组成，每一步可以向邻接的上下左右四格
//的通道移动。请求出从起点到终点所需的最小步数。请注意，本题假定从起点一定可以移动到终点。

import java.util.LinkedList;
import java.util.Queue;

//输入：
//N=10，M=10 (迷宫如下图所示。'#'， '.'，'S'，'G'分别表示墙壁、通道、起点和终点)
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

//输出：22
public class 迷宫最短路径 {
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

    int sx = 0, sy = 1;//起点
    int gx = 9, gy = 8;//终点

    //四个方向的向量
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};

    //到各个位置的最短距离数组
    int[][] d = new int[N][M];

    public static void main(String[] args) {
        new 迷宫最短路径().solve();
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
