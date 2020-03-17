package Offer;

//https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc?tpId=13&tqId=11218&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
//路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
//如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如
//  a   b   c   e
//  s   f   c   s
//  a   d   e   e
//矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
public class paths_in_a_matrix {
    public static void main(String[] args) {
        System.out.println(new paths_in_a_matrix.Solution().hasPath(
                new char[]{'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'},
                3, 4, new char[]{'b', 'c', 'c', 'e', 'd'}
        ));
    }

    //回溯法
    public static class Solution {
        public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
            boolean[] visited = new boolean[matrix.length];
            //可以从任何一个入口开始
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (helper(matrix, rows, cols, str, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean helper(char[] matrix, int rows, int cols, char[] str, int row, int col, int i, boolean[] visited) {
            //对应于一维数组的索引
            int index = row * cols + col;
            if (row < 0 || col < 0 || row >= rows || col >= cols ||
                    visited[index] || matrix[index] != str[i]) {
                return false;
            }
            if (i == str.length - 1) return true;
            visited[index] = true;
            if (helper(matrix, rows, cols, str, row - 1, col, i + 1, visited)
                    || helper(matrix, rows, cols, str, row + 1, col, i + 1, visited)
                    || helper(matrix, rows, cols, str, row, col + 1, i + 1, visited)
                    || helper(matrix, rows, cols, str, row, col - 1, i + 1, visited)) {
                return true;
            }
            visited[index] = false;
            return false;
        }
    }
}
