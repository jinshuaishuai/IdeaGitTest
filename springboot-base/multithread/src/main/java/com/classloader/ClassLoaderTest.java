package com.classloader;

import com.other.CostTimeTest;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author shuai.jin
 * @date 2021/5/28 11:32
 */
public class ClassLoaderTest {

    static class MyClassloader extends ClassLoader {

        private String path;

        public MyClassloader(String path) {
            this.path = path;
        }


        @SneakyThrows
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {

            byte[] data = load(name);


            return defineClass(name, data, 0, data.length);
        }

        private byte[] load(String name) throws IOException {

            File file = new File("D:/data/CostTimeTest.class");

            FileInputStream fileInputStream = new FileInputStream(file);
            int available = fileInputStream.available();
            byte[] data = new byte[available];
            fileInputStream.read(data);
            fileInputStream.close();
            return data;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        MyClassloader myClassloader = new MyClassloader("");

        Class<?> aClass = myClassloader.findClass("data/test/CostTimeTest");
        Object o = aClass.getDeclaredConstructor().newInstance();
        Method main = aClass.getDeclaredMethod("main");
        main.invoke(o,null);
        System.out.println(o.getClass().getClassLoader().getName());
    }
}
