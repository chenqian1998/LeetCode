package 关键字;

public class staticANDfinal {
    public static final void show() {

    }

    public static void main(String[] args) {
        System.out.println("static 代码块是不是先执行");
        Student p1 = new Student("c1", 22, null);
        //Person_sf p2 = new Person_sf("c1", 22, null);
        // static 修饰变量，其实强调的是一个共享的概念
        // 这个变量是多个对象共享的,所以创建多个对象，但是这个变量只会实例化一次
        //System.out.println(p1.getSon() == p2.getSon());

        // static 修饰方法，这个方法是类模板方法，也是多个对象共有的
        // 静态方法只能继承，不能覆写

        // static 修饰代码块,就和修饰静态变量一样，这个代码块只会执行一次
        // 就像上面创建了两个对象，但是静态代码块只运行了一次
        // 尤其注意，静态代码块的执行优先于构造函数


        // final 修饰变量表明这个变量说明这个值是不能被改写的，static修饰只说明多个对象的创建这个值只会实例化一次
        System.out.println(p1.getType());// 这个甚至连set方法也没有
        final int a = 10;
        // a = 20;出错

        final Student p = new Student("c1", 22, null);
        // p = new Person("c1",22,null); 出错，这个引用不能指向其他对象
        p.setAge(1000); // 修改这个对象的值是可以的

        //final 修饰方法，表明这个方法不能被继承

        // final 修饰一个类，说明这个类都不能被继承


    }
}
