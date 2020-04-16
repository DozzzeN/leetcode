package Offer;

//https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=13&tqId=11199&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
//其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
//每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,
//继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
//请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
//如果没有小朋友，请返回-1
public class the_last_number_left_in_the_circle {
    public static void main(String[] args) {
        System.out.println(new the_last_number_left_in_the_circle.Solution().LastRemaining_Solution(
                10, 7
        ));
    }

    public static class Solution {
        public int LastRemaining_Solution(int n, int m) {
            if (n == 0 || m == 0) return -1;
            int[] people = new int[n];
            for (int i = 0; i < n; i++) {
                people[i] = i;
            }
            int remove = -1;
            for (int left = n; left > 1; left--) {
                remove += m;
                if (remove >= left) {
                    remove %= left;
                }
                //模拟删除，将数组往前移，同时数组的范围缩小至left
                if (n - 1 - remove >= 0) System.arraycopy(people, remove + 1, people, remove, n - 1 - remove);
                remove--;
            }
            return people[0];
        }
    }
}
