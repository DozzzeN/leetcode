package Array_Matrix;

//766
//如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
//给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
public class toeplitz_matrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}};
//        int[][] matrix = {
//                {1,2},
//                {2,2}
//        };
        System.out.println(new toeplitz_matrix.Solution().isToeplitzMatrix(matrix));
    }

    static class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length - 1; i++) {//行遍历
                for (int j = 0; j < matrix[0].length - 1; j++) {//列遍历
                    if (matrix[i][j] != matrix[i + 1][j + 1]) {
                        return false;
                    }
                }
            }
            return true;
        }


    }
}
