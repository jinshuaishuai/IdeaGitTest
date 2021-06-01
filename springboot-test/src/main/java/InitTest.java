import com.jin.bean.Person;
import lombok.Data;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shuai.jin
 * @date 2021/4/7 14:05
 */
@Data
public class InitTest {

    private List<Person> personList;

    private Long componentId;

    private long id;

    private int i1;

    private Person person;

    private Integer integer;

    public static void main(String[] args) {


        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("aaa","bbb");
        map.put(null, "ccc");
        map.put("ccc", null);
        System.out.println(map);
    }
}
