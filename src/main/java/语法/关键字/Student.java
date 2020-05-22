package 语法.关键字;

import 语法.domain.Pet;

class Person {
    String name;
    int age;

    static {
        System.out.println("开始父类的static代码块");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("开始父类的构造函数");
    }
}

public class Student extends Person {
    private String name;
    private int age;
    private Pet pet;
    //private static Student son = new Student("jojo", 18, null);
    private final String type = "人类";

    static {
        System.out.println("====开始子类中的静态方法块====");
    }


    public Student(String name, int age, Pet pet) {
        super(name, age);
        this.pet = pet;
        System.out.println("开始子类的构造函数");
    }


    public static void printPerson() {
        System.out.println("这个是 Person 类");
    }


    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getType() {
        return type;
    }

}

