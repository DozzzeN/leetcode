package Array_Matrix;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        list2.add(2);

        System.out.println(list2.removeAll(list1));
        System.out.println(list2);
    }
}
