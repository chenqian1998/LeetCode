package 语法.序列化;

import 语法.domain.Person;
import 语法.domain.Pet;

public class 浅深拷贝 {
    public static void main(String[] args) {
        Pet pet = new Pet("xiao bai",2);
        Person p = new Person("chen qian",22,pet);

        Person p2 = (Person) p.clone();

        // 浅层拷贝中，p,p2中的基本类型进行了拷贝
        System.out.println(p == p2);
        System.out.println(p.hashCode()+" "+p2.hashCode());

        // 但是引用类型（String,Pet)是没有创建新的对象
        // clone()之后两个属性的引用指向同一个内存地址
        System.out.println(p.getName().hashCode() == p2.getName().hashCode());
        System.out.println(p.getPet() == p2.getPet());


    }
}
