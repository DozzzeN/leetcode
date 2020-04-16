package Offer;

//https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&tqId=11207&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
//当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
public class the_first_non_repeating_character_in_the_character_stream {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "helloworld";
        for (int i = 0; i < input.length(); i++) {
            solution.Insert(input.charAt(i));
        }
        System.out.println(solution.FirstAppearingOnce());
    }

    static public class Solution {
        private int[] hashtable = new int[256];
        private String string = "";

        public void Insert(char ch) {
            hashtable[ch]++;
            string += ch;
        }

        public char FirstAppearingOnce() {
            for (int i = 0; i < string.length(); i++) {
                if (hashtable[string.charAt(i)] == 1)
                    return string.charAt(i);
            }
            return '#';
        }
    }
}
