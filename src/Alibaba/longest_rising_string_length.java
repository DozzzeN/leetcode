package Alibaba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//���ȶ��������ַ�����s[i] >= s[i-1]������aaa,abc�ǣ�acb����
//��n�������ַ�����ѡ�������ƴ����������ƴ������������ַ������ȡ�
public class longest_rising_string_length {
    public static void main(String[] args) {
        System.out.println(maxLengthConcat(new String[]{
                "abc", "def", "deft", "abcde", "efgh"
        }));
    }

    public static int maxLengthConcat(String[] str) {
        int result = 0;
        if (str == null || str.length == 0) return result;
        Map<Integer, ArrayList<String>> map = new HashMap<>();
        int[] dp = new int[26];
        int[] add = new int[26];//���ڽ��������"aaaa"���ַ���
        for (String s : str) {
            if (!map.containsKey(s.charAt(0) - 'a')) {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(s.charAt(0) - 'a', list);
            } else {
                map.get(s.charAt(0) - 'a').add(s);
            }
        }
        dp[0] = 0;
        for (int j = 1; j < 26; j++) {
            for (int i = 0; i <= j; i++) {
                if (map.containsKey(i)) {
                    for (int k = 0; k < map.get(i).size(); k++) {
                        String s = map.get(i).get(k);
                        //dpj=max(dpj-1,dpi+Sij) dpj��ʾ��j��β����ַ������ȣ�Sij��ʾ��i��ʼj�������ַ���
                        if (s != null && s.charAt(s.length() - 1) - 'a' <= j) {
                            if (s.charAt(s.length() - 1) == s.charAt(0)) {//"aaaa"
                                add[i] = s.length();
                            } else {
                                dp[j] = Math.max(dp[j - 1], dp[i] + s.length());
                            }
                        }
                    }
                }
                result = Math.max(result, add[i] + dp[j]);
            }
        }
        return result;
    }
}
