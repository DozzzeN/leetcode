import java.util.HashMap;
import java.util.Map;

public class Foo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>(); // 1
        map.put("a", 127); // 2
        map.put("b", new Integer(127)); // 3
        map.put(null, null); // 4
        System.out.println(map.get("a") == (map.get("b"))); // 5
    }
}