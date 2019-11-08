package UnionFindSet;

//959
//在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
//（请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
//返回区域的数目。
//示例 1：
//输入：
//[
//  " /",
//  "/ "
//]
//输出：2
//解释：2x2 网格如下：
//示例 2：
//输入：
//[
//  " /",
//  "  "
//]
//输出：1
//解释：2x2 网格如下：
//示例 3：
//输入：
//[
//  "\\/",
//  "/\\"
//]
//输出：4
//解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
//2x2 网格如下：
//示例 4：
//输入：
//[
//  "/\\",
//  "\\/"
//]
//输出：5
//解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
//2x2 网格如下：
//示例 5：
//输入：
//[
//  "//",
//  "/ "
//]
//输出：3
//解释：2x2 网格如下：
//提示：
//	1 <= grid.length == grid[0].length <= 30
//	grid[i][j] 是 '/'、'\'、或 ' '。
public class regions_cut_by_slashes {
    public static void main(String[] args) {
        System.out.println(new regions_cut_by_slashes.Solution().regionsBySlashes(new String[]{
                " /",
                "/ "
        }));
    }

    //  ┏  0  ┓      0 /    \ 0
    //  1     2    1 / 2   1 \ 2
    //  ┗  3  ┛     / 3      3 \
    //"/"划分后0和1求并 2和3求并
    //"\"划分后0和2求并 1和3求并
    //  ┏  0   ┓    ┏   4  ┓
    //  1      2 —— 5     6
    //  ┗  3   ┛    ┗   7  ┛
    //     |           |
    //  ┏  8   ┓    ┏  12  ┓
    //  9     10 ——13    14
    //  ┗  11  ┛    ┗  15  ┛
    //上下左右相应地进行合并连接
    static class Solution {
        public int regionsBySlashes(String[] grid) {
            int n = grid.length;
            UnionFindSet unionFindSet = new UnionFindSet(4 * n * n);
            for (int r = 0; r < n; r++)
                for (int c = 0; c < n; c++) {
                    int index = 4 * (r * n + c);
                    char val = grid[r].charAt(c);
                    if (val != '\\') {
                        unionFindSet.Union(index, index + 1);
                        unionFindSet.Union(index + 2, index + 3);
                    }
                    if (val != '/') {
                        unionFindSet.Union(index, index + 2);
                        unionFindSet.Union(index + 1, index + 3);
                    }
                    if (r + 1 < n)
                        unionFindSet.Union(index + 3, (index + 4 * n));
                    if (r - 1 >= 0)
                        unionFindSet.Union(index, (index - 4 * n) + 3);
                    if (c + 1 < n)
                        unionFindSet.Union(index + 2, (index + 4) + 1);
                    if (c - 1 >= 0)
                        unionFindSet.Union(index + 1, (index - 4) + 2);
                }

            int result = 0;
            for (int i = 0; i < 4 * n * n; i++) {
                if (unionFindSet.Find(i) == i)
                    result++;
            }
            return result;
        }
    }
}
