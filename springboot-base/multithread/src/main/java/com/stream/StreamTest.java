package com.stream;

import java.util.stream.Stream;

/**
 * @author shuai.jin
 * @date 2020/9/17 18:53
 */
public class StreamTest {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("a", "bc", "c");
        System.out.println(stringStream);

        String[] arrays = {"a","bc","c"};
        Stream<String> stringStream1 = Stream.of(arrays);
        System.out.println(stringStream == stringStream1);

        System.out.println(stringStream);
    }
}
