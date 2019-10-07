package BackTracking;

import java.util.ArrayList;
import java.util.List;

//93
//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//示例:
//输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"]
public class restore_ip_addresses {
    public static void main(String[] args) {
        List<String> result = new restore_ip_addresses.Solution().restoreIpAddresses("010010");
        for (String s : result) {
            System.out.println(s);
        }
    }

    static class Solution {
        List<String> result = new ArrayList<>();
        StringBuilder IP = new StringBuilder();

        public List<String> restoreIpAddresses(String s) {
            restoreIpAddresses(s, 0, 0);
            return result;
        }

        public void restoreIpAddresses(String s, int start, int partNum) {
            if (partNum == 4) {
                if (start != s.length()) {
                    return;
                }
                String solution = new String(IP);
                result.add(solution.substring(0, solution.length() - 1));
                return;
            }
            for (int i = 1; i <= 3 && i + start <= s.length(); i++) {
                String num = s.substring(start, i + start);
                if (isValid(num)) {
                    IP.append(num).append('.');
                    restoreIpAddresses(s, start + i, partNum + 1);
                    IP.delete(IP.length() - num.length() - 1, IP.length());
                }
            }
        }

        public boolean isValid(String s) {
            if (s.charAt(0) == '0' && s.length() > 1) return false;
            int number = Integer.parseInt(s);
            return number >= 0 && number <= 255;
        }
    }
}
