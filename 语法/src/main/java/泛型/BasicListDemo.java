package 泛型;

import domain.Person;
import domain.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/4/20 6:06 下午
 */
public class BasicListDemo {
    public static void main(String[] args) {
        List<? super Person> list = new ArrayList<>();
        List<Person> list1 = new ArrayList<>();
        List<Student> list2 = new ArrayList<>();
        List<Object> list3 = new ArrayList<>();

        // 1,赋值
        // List泛型是Person的父类都可以赋值
        list = list1;
        list = list3;

        // error
        // list = list2;

        // 2. add()添加元素,只能添加Person的子类
        list.add(new Person());
        list.add(new Student());
        // error
        // list.add(new Object());
        Person p = new Person();
        // 可以把父类强制转换成子类？？
        Student s = (Student) p;



        // 可以把父类强制转换成子类？？
        Student s1 = new Student();
        Person p1 = (Student) s1;


    }
}
