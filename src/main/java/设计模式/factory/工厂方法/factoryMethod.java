package 设计模式.factory.工厂方法;

abstract class Product {
    public abstract void method();
}

class ProductA extends Product {

    @Override
    public void method() {
        System.out.println("生产ProductA");
    }
}

abstract class Factory<T> {
    // 请问抽象工厂和工厂方法的区别在哪里呢？？
    // 1、抽象工厂有多个产品族，而工厂方法一般只有一个（也就是说如果有多个产品族，就是抽象工厂了）。
    // 2、抽象工厂也会有一些问题，就是产品族增加了就要修改接口
    abstract Product createProduct(Class<T> c);
}

class FactoryA extends Factory {

    @Override
    Product createProduct(Class c) {
        Product product = null;
        try {
            product = (Product) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}

public class factoryMethod {
    public static void main(String[] args) {
        Factory factory = new FactoryA();
        Product product = factory.createProduct(ProductA.class);
        product.method();

    }

}
