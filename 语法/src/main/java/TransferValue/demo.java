package TransferValue;

public class demo {
    public void changeInt(int age) {
        age = 20;
    }

    public void changeObject(Person p) {
        p.name = "例子";
    }

    public void changeObject2(Person p) {
        p = new Person("lisi", 22);
        //System.out.println(p.name);
    }

    public void changeString(String s) {
        s = "niuniuniu";
    }

    public void changeInteger(Integer i) {
        // i = i + 1;
        // i = 20;
        // i = new Integer(20);
        // i++;
    }

    public static void main(String[] args) {
        demo d = new demo();
        int age = 10;
        // 我们通过一个方法去修改main方法中我们定义的这个值
        // 其实changeInt(）方法中改变的是这个值的副本，原来的值不会改变的
        d.changeInt(age);
        System.out.println(age);


        // 但是这个却变了？？？？？
        // 其实都是值传递，拷贝了一份字面量，还是指向这个实例对象的
        Person p = new Person("zhangsan", 10);
        d.changeObject2(p);
        System.out.println(p.name);

        String name = "da";
        // String也不是基本类型，为啥它不改变呢？？？？？
        // 这个和JVM的实现有关。JVM中有一个字符串常量池，没有的字符串就创建，有的话就复用

        //public void changeString(String s){
        //        s = "niuniuniu";
        //    }
        //
        //所以上面这个方法，一开始传进去的s指向"da"字符串
        // 但是后来创建了"niuniuniu"，这个s又重新指向"niuniuniu"了

        d.changeString(name);
        System.out.println(name);

        Integer i = 10;
        d.changeInteger(i);
        System.out.println(i);


    }
}
