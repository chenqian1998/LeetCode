package 注解;

import java.lang.reflect.Method;

public class main {
    @Hello("那是真的牛皮！")
    public static void main(String[] args) throws NoSuchMethodException {
        Class clazz = main.class;
        Method main = clazz.getMethod("main", String[].class);
        Hello annotation = main.getAnnotation(Hello.class);
        System.out.println(annotation.value());
    }
}
