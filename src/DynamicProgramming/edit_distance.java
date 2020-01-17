package DynamicProgramming;

//72
//给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
//你可以对一个单词进行如下三种操作：
//	插入一个字符
//	删除一个字符
//	替换一个字符
//示例 1:
//输入: word1 = "horse", word2 = "ros"
//输出: 3
//解释:
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//示例 2:
//输入: word1 = "intention", word2 = "execution"
//输出: 5
//解释:
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
public class edit_distance {
    public static void main(String[] args) {
        System.out.println(new edit_distance.Solution().minDistance("", "a"));
    }

    //D[i][j] 表示 word1 的前 i 个字母和 word2 的前 j 个字母之间的编辑距离
    //如果两个子串的最后一个字母相同，word1[i] = word2[j] 的情况下：
    //D[i][j] = D[i - 1][j - 1]
    //否则，word1[i] != word2[j] 我们将考虑替换最后一个字符使得他们相同：
    //D[i][j] = 1 + min(D[i - 1][j], D[i][j - 1], D[i - 1][j - 1])
    static class Solution {
        public int minDistance(String word1, String word2) {
            int[][] D = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i <= word1.length(); i++) {
                D[i][0] = i;
            }
            for (int j = 0; j <= word2.length(); j++) {
                D[0][j] = j;
            }
            for (int i = 0; i < word1.length(); i++) {
                for (int j = 0; j < word2.length(); j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        D[i + 1][j + 1] = D[i][j];
                    } else {
                        D[i + 1][j + 1] = 1 + Math.min(
                                Math.min(D[i][j + 1], D[i][j]), D[i + 1][j]
                        );
                    }
                }
            }
            return D[word1.length()][word2.length()];
        }
    }
}
