import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author shuai.jin
 * @date 2021/4/2 15:30
 */
public class IntegerTest {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        list.add(map1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("a", 3);
        map2.put("b", 4);

        list.add(map2);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("a", 5);
        map3.put("b", 6);

        list.add(map3);

        List<Map<String, Object>> collect = list.stream().skip(0).limit(1).collect(Collectors.toList());
        System.out.println(collect);

    }

    public void abc() throws InterruptedException {
        wait();


        Set<String> set = new TreeSet<>();
        set.add("aaa");

        set.add("aaa");
        System.out.println(set.size());
    }
}
