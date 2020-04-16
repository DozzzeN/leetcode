package Offer;

//https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
//请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
public class replace_blank_space02 {
    public static void main(String[] args) {
        System.out.println(new replace_blank_space02.Solution().replaceSpace(new StringBuffer()));
    }

    //①在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。因为一个空格要替换成三个字符（%20），
    //所以当遍历到一个空格时，需要在尾部填充两个任意字符。
    //②令P1指向字符串原来的末尾位置，P2指向字符串现在的末尾位置。P1和P2从后向前遍历，当P1遍历到一个空格时，
    //就需要令P2指向的位置依次填充02%（注意是逆序的），否则就填充上P1指向字符的值。
    //从后向前遍是为了在改变P2所指向的内容时，不会影响到P1遍历原来字符串的内容。
    //③当P2遇到P1时（P2<=P1），或者遍历结束（P1<0），退出。
    public static class Solution {
        public String replaceSpace(StringBuffer str) {
            int P1 = str.length() - 1;
            for (int i = 0; i <= P1; i++)
                if (str.charAt(i) == ' ')
                    str.append("  ");

            int P2 = str.length() - 1;
            while (P1 >= 0 && P2 > P1) {
                char c = str.charAt(P1--);
                if (c == ' ') {
                    str.setCharAt(P2--, '0');
                    str.setCharAt(P2--, '2');
                    str.setCharAt(P2--, '%');
                } else {
                    str.setCharAt(P2--, c);
                }
            }
            return str.toString();
        }
    }
}
