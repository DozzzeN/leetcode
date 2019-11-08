package UnionFindSet;

//765
//N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
//人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
//这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
//示例 1:
//输入: row = [0, 2, 1, 3]
//输出: 1
//解释: 我们只需要交换row[1]和row[2]的位置即可。
//示例 2:
//输入: row = [3, 2, 0, 1]
//输出: 0
//解释: 无需交换座位，所有的情侣都已经可以手牵手了。
//说明:
//	len(row) 是偶数且数值在 [4, 60]范围内。
//	可以保证row 是序列 0...len(row)-1 的一个全排列。
public class couples_holding_hands {
    public static void main(String[] args) {
        System.out.println(new couples_holding_hands.Solution().minSwapsCouples(new int[]{
                5, 6, 4, 0, 2, 1, 9, 3, 8, 7, 11, 10
        }));
    }

    //重排数组 将原数组每两个元素进行划分
    //新数组保存偶数，如果遇到奇数就减一
    //并查集合并新数组的每一列，如果需要并查集中find(i)!=i的就需要交换
    static class Solution {
        public int minSwapsCouples(int[] row) {
            int result = 0;
            if (row == null || row.length == 0) return result;
            UnionFindSet unionFindSet = new UnionFindSet(row.length);
            int[][] couple = new int[row.length / 2][2];
            for (int i = 0; i < row.length - 1; i++) {
                if (i % 2 == 0) {
                    couple[i / 2][0] = row[i] % 2 == 0 ? row[i] : row[i] - 1;
                    couple[i / 2][1] = row[i + 1] % 2 == 0 ? row[i + 1] : row[i + 1] - 1;
                }
            }
            for (int i = 0; i < row.length / 2; i++) {
                unionFindSet.Union(couple[i][0], couple[i][1]);
            }
            for (int i = 0; i < row.length; i++) {
                if (unionFindSet.Find(i) != i) {
                    result++;
                }
            }
            return result;
        }
    }
}
