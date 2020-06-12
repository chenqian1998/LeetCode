import domain.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Comparable_Comparator {
    // 比较comparable comparator
    public static void comparableANDcomparator() {
        Person p1 = new Person("a",10,null);
        Person p2 = new Person("m",14,null);
        Person p3 = new Person("c",3,null);

        ArrayList<Person> list = new ArrayList<>();

        list.add(p1);
        list.add(p2);
        list.add(p3);

        // 由于类Person 实现了Comparable 接口，所以在排序的时候会按照我们设定好的
        // Collections.sort(list);


        for(Person p : list){
            System.out.println(p.toString());
        }

        /*
        如果类没有实现Comparable(可比较)接口，那么我们可以传入一个Comparator(比较器）
         */
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                // 这个比较 o1 是否比 o2 大？
                // 就看返回值： >0 说明 o1>o2
                return o2.getAge() - o1.getAge();
            }
        });
        System.out.println("============");
        for(Person p : list){
            System.out.println(p.toString());
        }
    }

    public static void main(String[] args) {
        comparableANDcomparator();
    }


}
