package UnionFindSet;

import java.util.*;

//721
//����һ���б� accounts��ÿ��Ԫ�� accounts[i] ��һ���ַ����б����е�һ��Ԫ�� accounts[i][0] �� ���� (name)������Ԫ���� emails ��ʾ���ʻ��������ַ��
//���ڣ�������ϲ���Щ�ʻ�����������ʻ�����һЩ��ͬ���ʼ���ַ���������ʻ��ض�����ͬһ���ˡ���ע�⣬��ʹ�����ʻ�������ͬ�����ƣ�����Ҳ�������ڲ�ͬ���ˣ���Ϊ���ǿ��ܾ�����ͬ�����ơ�һ�����������ӵ�������������ʻ������������ʻ���������ͬ�����ơ�
//�ϲ��ʻ��󣬰����¸�ʽ�����ʻ���ÿ���ʻ��ĵ�һ��Ԫ�������ƣ�����Ԫ���ǰ�˳�����е������ַ��accounts �������������˳�򷵻ء�
//���� 1:
//Input:
//accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"],
//["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
//Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
//Explanation:
//  ��һ���͵����� John ��ͬһ���ˣ���Ϊ�����й�ͬ�ĵ����ʼ� "johnsmith@mail.com"��
//  �ڶ��� John �� Mary �ǲ�ͬ���ˣ���Ϊ���ǵĵ����ʼ���ַû�б������ʻ�ʹ�á�
//  ���ǿ������κ�˳�򷵻���Щ�б������[['Mary'��'mary@mail.com']��['John'��'johnnybravo@mail.com']��
//  ['John'��'john00@mail.com'��'john_newyork@mail.com'��'johnsmith@mail.com']]��Ȼ�ᱻ���ܡ�
//ע�⣺
//	accounts�ĳ��Ƚ���[1��1000]�ķ�Χ�ڡ�
//	accounts[i]�ĳ��Ƚ���[1��10]�ķ�Χ�ڡ�
//	accounts[i][j]�ĳ��Ƚ���[1��30]�ķ�Χ�ڡ�
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
            //����������-�����ַ�Ĺ�ϣ��
            Map<Integer, List<String>> map = new HashMap<>();
            for (int i = 0; i < accounts.size(); i++) {
                map.put(i, new ArrayList<>(accounts.get(i)));
                map.get(i).remove(0);
            }
            //��ͬ�����ַ�����������ַ�н����������ַ�����кϲ�
            UnionFindSet unionFindSet = new UnionFindSet(accounts.size() - 1);
            for (int i = 0; i < accounts.size(); i++) {
                for (int j = i; j < accounts.size(); j++) {
                    if (isUnion(map.get(i), map.get(j))) {
                        unionFindSet.Union(i, j);
                    }
                }
            }
            //�ϲ���ͬ�������ַ��ֻ�������ڵ�parent
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
            //ʹ��map��������list��ȥ�ء��ֵ�����
            List<List<String>> result = new ArrayList<>();
            for (int i = 0; i < accounts.size(); i++) {
                int j = unionFindSet.Find(i);
                if (j == i) {
                    List<String> list = new ArrayList<>();
                    list.add(accounts.get(j).get(0));
                    List<String> unsort = new ArrayList<>(map.get(j));
                    //���ֵ�����ȥ��
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
