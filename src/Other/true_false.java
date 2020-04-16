package Other;

import java.util.ArrayList;

public class true_false {
    public static void main(String[] args) {
        System.out.println(genInterpretations(3));
    }

    public static ArrayList<ArrayList<Boolean>> genInterpretations(int n) {
        ArrayList<ArrayList<Boolean>> result = new ArrayList<>();
        if (n <= 0) return result;
        helper(n, new ArrayList<>(), result);
        return result;
    }

    public static void helper(int target, ArrayList<Boolean> solution, ArrayList<ArrayList<Boolean>> result) {
        if (solution.size() == target) {
            result.add(new ArrayList<>(solution));
        } else {
            for (int i = 0; i < 2; i++) {
                boolean element = i != 0;
                solution.add(element);
                helper(target, solution, result);
                solution.remove(solution.size() - 1);
            }
        }
    }
}
