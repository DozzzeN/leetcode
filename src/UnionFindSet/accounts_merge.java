package UnionFindSet;

import java.util.*;

//721
//给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该帐户的邮箱地址。
//现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。
//合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。accounts 本身可以以任意顺序返回。
//例子 1:
//Input:
//accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"],
//["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
//Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
//Explanation:
//  第一个和第三个 John 是同一个人，因为他们有共同的电子邮件 "johnsmith@mail.com"。
//  第二个 John 和 Mary 是不同的人，因为他们的电子邮件地址没有被其他帐户使用。
//  我们可以以任何顺序返回这些列表，例如答案[['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
//  ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']]仍然会被接受。
//注意：
//	accounts的长度将在[1，1000]的范围内。
//	accounts[i]的长度将在[1，10]的范围内。
//	accounts[i][j]的长度将在[1，30]的范围内。
public class accounts_merge {
    public static void main(String[] args) {
        String[][] input = new String[][]{
                {"Kevin", "Kevin20@m.co", "Kevin9@m.co", "Kevin18@m.co", "Kevin15@m.co", "Kevin17@m.co"},
                {"Kevin", "Kevin15@m.co", "Kevin19@m.co", "Kevin0@m.co", "Kevin6@m.co", "Kevin13@m.co"},
                {"Kevin", "Kevin5@m.co", "Kevin11@m.co", "Kevin13@m.co", "Kevin16@m.co", "Kevin2@m.co"},
                {"Kevin", "Kevin3@m.co", "Kevin4@m.co", "Kevin15@m.co", "Kevin14@m.co", "Kevin16@m.co"},
                {"Kevin", "Kevin18@m.co", "Kevin8@m.co", "Kevin16@m.co", "Kevin2@m.co", "Kevin8@m.co"},
                {"Kevin", "Kevin20@m.co", "Kevin10@m.co", "Kevin0@m.co", "Kevin4@m.co", "Kevin7@m.co"},
                {"Kevin", "Kevin11@m.co", "Kevin17@m.co", "Kevin17@m.co", "Kevin11@m.co", "Kevin13@m.co"},
                {"Kevin", "Kevin11@m.co", "Kevin13@m.co", "Kevin4@m.co", "Kevin15@m.co", "Kevin11@m.co"},
                {"Kevin", "Kevin13@m.co", "Kevin5@m.co", "Kevin6@m.co", "Kevin12@m.co", "Kevin14@m.co"},
                {"Kevin", "Kevin11@m.co", "Kevin16@m.co", "Kevin20@m.co", "Kevin14@m.co", "Kevin4@m.co"},
                {"Kevin", "Kevin9@m.co", "Kevin2@m.co", "Kevin13@m.co", "Kevin6@m.co", "Kevin3@m.co"},
                {"Kevin", "Kevin20@m.co", "Kevin7@m.co", "Kevin17@m.co", "Kevin12@m.co", "Kevin0@m.co"},
                {"Kevin", "Kevin9@m.co", "Kevin9@m.co", "Kevin9@m.co", "Kevin12@m.co", "Kevin18@m.co"},
                {"Kevin", "Kevin15@m.co", "Kevin10@m.co", "Kevin14@m.co", "Kevin13@m.co", "Kevin20@m.co"},
                {"Kevin", "Kevin15@m.co", "Kevin18@m.co", "Kevin13@m.co", "Kevin10@m.co", "Kevin19@m.co"},
                {"Kevin", "Kevin8@m.co", "Kevin15@m.co", "Kevin4@m.co", "Kevin3@m.co", "Kevin10@m.co"},
                {"Kevin", "Kevin6@m.co", "Kevin9@m.co", "Kevin10@m.co", "Kevin9@m.co", "Kevin6@m.co"},
                {"Kevin", "Kevin2@m.co", "Kevin8@m.co", "Kevin12@m.co", "Kevin5@m.co", "Kevin9@m.co"},
                {"Kevin", "Kevin15@m.co", "Kevin20@m.co", "Kevin9@m.co", "Kevin17@m.co", "Kevin4@m.co"},
                {"Kevin", "Kevin0@m.co", "Kevin4@m.co", "Kevin0@m.co", "Kevin0@m.co", "Kevin1@m.co"}
        };
        List<List<String>> lists = new ArrayList<>();
        for (String[] strings : input) {
            lists.add(new ArrayList<>(Arrays.asList(strings)));
        }
        List<List<String>> result = new accounts_merge.Solution().accountsMerge(lists);
        for (List<String> strings : result) {
            System.out.println(strings);
        }
    }

    static class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            //建立索引号-邮箱地址的哈希表
            Map<Integer, List<String>> map = new HashMap<>();
            for (int i = 0; i < accounts.size(); i++) {
                map.put(i, new ArrayList<>(accounts.get(i)));
                map.get(i).remove(0);
            }
            //相同邮箱地址（所有邮箱地址有交集的邮箱地址）进行合并
            UnionFindSet unionFindSet = new UnionFindSet(accounts.size() - 1);
            for (int i = 0; i < accounts.size(); i++) {
                for (int j = i; j < accounts.size(); j++) {
                    if (isUnion(map.get(i), map.get(j))) {
                        unionFindSet.Union(i, j);
                    }
                }
            }
            //合并相同的邮箱地址，只保留根节点parent
            for (int i = 0; i < accounts.size(); i++) {
                int j = unionFindSet.Find(i);
                if (i != j) {
                    List<String> list = new ArrayList<>(map.get(i));
                    for (String s : list) {
                        if (!map.get(j).contains(s)) {
                            map.get(j).add(s);
                        }
                    }
                    map.remove(i);
                }
            }
            //使用map构造出结果list，去重、字典排序
            List<List<String>> result = new ArrayList<>();
            for (int i = 0; i < accounts.size(); i++) {
                int j = unionFindSet.Find(i);
                if (j == i) {
                    List<String> list = new ArrayList<>();
                    list.add(accounts.get(j).get(0));
                    List<String> unsort = new ArrayList<>(map.get(j));
                    //按字典排序，去重
                    Collections.sort(unsort);
                    for (int k = 0; k < unsort.size() - 1; k++) {
                        if (unsort.get(k).equals(unsort.get(k + 1))) {
                            unsort.remove(k + 1);
                            k--;
                        }
                    }
                    list.addAll(unsort);
                    result.add(list);
                }
            }
            return result;
        }

        public boolean isUnion(List<String> list1, List<String> list2) {
            for (int i = 0; i < list1.size(); i++) {
                if (list2.contains(list1.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }
}
