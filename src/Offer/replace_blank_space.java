package Offer;
//https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
//请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
public class replace_blank_space {
    public static class Solution {
        public String replaceSpace(StringBuffer str) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    str.deleteCharAt(i);
                    str.insert(i, "%20");
                }
            }
            return str.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new replace_blank_space.Solution().replaceSpace(new StringBuffer("")));
    }
}
