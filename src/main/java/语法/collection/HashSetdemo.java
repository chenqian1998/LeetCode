package 语法.collection;


import 语法.domain.Person;

import java.util.*;

public class HashSetdemo {
    public static void main(String[] args) {
        // 类似hashmap了
        HashSet<String> hashSet = new HashSet<>();

        // 底层是红黑树
        TreeSet<Person> treeSet = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        Person p1 = new Person("a",10,null);
        Person p2 = new Person("m",14,null);
        Person p3 = new Person("c",3,null);
        Person p4 = new Person("a",2,null);
        Person p5 = new Person("m",100,null);
        Person p6 = new Person("c",9,null);

        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);
        treeSet.add(p2);
        treeSet.add(p3);
        treeSet.add(p4);
        treeSet.add(p5);
        treeSet.add(p6);
        treeSet.add(p1);

        System.out.println(treeSet);
        Iterator<Person> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            Person next = iterator.next();
            System.out.println(next.getAge());
        }

    }
}
