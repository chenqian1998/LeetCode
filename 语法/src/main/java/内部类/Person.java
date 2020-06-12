package 内部类;

import java.util.concurrent.ConcurrentHashMap;

public abstract class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void speaking(){
        System.out.println("aaa");
    }

    public abstract void eating();

    public static void main(String[] args) {
        // 可以看出这个抽象的类Person就可以new了，只要都实现了其中的抽象方法
        Person p = new Person(1,"cq") {
            @Override
            public void eating() {
                System.out.println("eating..");
            }
        };
        p.eating();

        // 甚至接口也可以！
        new niubilable() {
            public void niubi() {
                System.out.println("niubi");
            }
        }.niubi();
    }
}


interface niubilable{
    public void niubi();
}


// 如果这个类Student只使用一次的话，那每次创建一个类就很麻烦，所以java提供了一种机制
class Student extends Person {

    public Student(int id, String name) {
        super(id, name);
    }

    public void eating() {
        System.out.println("eat..");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    }

}