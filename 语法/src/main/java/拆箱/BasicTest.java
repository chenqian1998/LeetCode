package 拆箱;

import domain.Person;

public class BasicTest {
    public static void add(Byte b) {

        System.out.println("===== 方法内 ====");
        b++;
        System.out.println(b);
        System.out.println("===== 方法内 ====");
    }

    public static void addAge(Person p) {
        p.setAge(p.getAge() + 1);
        System.out.println("===== 方法内 ====");
        System.out.println(p);
        System.out.println("===== 方法内 ====");
    }


    public static void main(String[] args) {
        Byte a = 127;
        add(a);
        // 一个很骚的地方: a = a++; 这个a的值是不变的
        System.out.println(a);

//        Person p = new Person("abc", 11, null);
//        addAge(p);
//        System.out.println(p);

    }

}
