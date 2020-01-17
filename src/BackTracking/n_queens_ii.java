package BackTracking;

import java.util.ArrayList;
import java.util.List;

//52
//n �ʺ������о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
//����һ������ n������ n �ʺ�ͬ�Ľ��������������
//ʾ��:
//����: 4
//���: 2
//����: 4 �ʺ������������������ͬ�Ľⷨ��
//[
// [".Q..",  // �ⷨ 1
//  "...Q",
//  "Q...",
//  "..Q."],
// ["..Q.",  // �ⷨ 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//
public class n_queens_ii {
    public static void main(String[] args) {
        System.out.println(new n_queens_ii.Solution().totalNQueens(11));
    }

    static class Solution {
        List<Position> solution = new ArrayList<>();
        int count = 0;

        public int totalNQueens(int n) {
            backtrack(n, 0);
            //������
            return count;
        }

        //ʱ�临�Ӷȣ�O(n!)
        //��һ���ʺ�n �������ʺ�n-2
        //n * (n-2) * (n-4) ...
        public boolean canPut(int n, int row, int col) {
            if (row > n - 1 || col > n - 1 || row < 0 || col < 0) return false;
            int left = row - Math.min(row, col);
            int top = col - Math.min(row, col);
            for (Position position : solution) {
                if (row == position.x) return false;
                if (col == position.y) return false;
                //���Խ���
                if (left == position.x - Math.min(position.x, position.y) &&
                        top == position.y - Math.min(position.x, position.y))
                    return false;
                //���Խ���
                if (row + col == position.x + position.y) return false;
            }
            return true;
        }

        public void backtrack(int n, int row) {
            for (int col = 0; col < n; col++) {
                if (canPut(n, row, col)) {
                    solution.add(new Position(row, col));
                    if (solution.size() == n) {
                        count++;
                    } else backtrack(n, row + 1);
                    solution.remove(solution.size() - 1);
                }
            }
        }

        //�������λ��
        static class Position {
            int x;
            int y;

            Position(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
