package threadLocal;

import 语法.domain.Person;

public class demo {
    public static void main(String[] args) {
        Object object = new Object();
        Person person = new Person("c",11,null);

        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set(object);

        ThreadLocal<Person> threadLocal2 = new ThreadLocal();
        threadLocal.set(person);

        threadLocal2.remove();

        // 其实也就是说你要保存两个变量的信息就需要你
        System.out.println(threadLocal2.get());


    }
}
