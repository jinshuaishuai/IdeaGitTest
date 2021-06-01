import com.jin.bean.Person;

import java.util.*;

/**
 * @author shuai.jin
 * @date 2021/3/5 9:48
 */
public class SalaryTest {
    public static void main(String[] args) {

        bbb();
//        aaa();

//        ccc();
    }

    private static void ccc() {

        String s1 = "123";

        String s2 = new String("123");

        String s3 = "" + "123";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        System.out.println(s1 == s3);
        System.out.println(s2 == s3);

        HashSet<Person> sets = new HashSet<>();
        Person p1 = new Person();
        p1.setAge(12);
        p1.setName("aaa");

        Person p2 = new Person();
        p2.setName("aaa");
        p2.setAge(12);

        sets.add(p1);
        sets.add(p2);

        System.out.println(sets.size());

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
    }

    private static void bbb() {
        TreeSet<String> set = new TreeSet<>();
        set.add("aaa");

        set.add("aaa");
        System.out.println(set.size());
    }

    private static void aaa() {
        Set<Person> sets = new TreeSet<>();
        Person p1 = new Person();
        p1.setAge(12);
        p1.setName("aaa");

        Person p2 = new Person();
        p2.setName("aaa");
        p2.setAge(12);

        sets.add(p1);
        sets.add(p2);

        System.out.println(sets.size());
    }
}
