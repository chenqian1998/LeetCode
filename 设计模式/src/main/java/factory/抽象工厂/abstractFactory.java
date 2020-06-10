package factory.抽象工厂;

interface factory {
    public Phone makePhone();

    public TV makeTV();
}

class Phone {
    String name;
    double price;

    public Phone(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class TV{
    String name;
    double price;

    public TV(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// 具体的产品
class HWPhone extends Phone{

    public HWPhone(String name, double price) {
        super(name, price);
    }
}

class HWTV extends TV{
    public HWTV(String name, double price){
        super(name,price);
    }
}

class MiPhone extends Phone{

    public MiPhone(String name, double price) {
        super(name, price);
    }
}

class MiTV extends  TV{

    public MiTV(String name, double price) {
        super(name, price);
    }
}

// 具体的工厂
class HWFactory implements factory{

    @Override
    public Phone makePhone() {
        return new HWPhone("mate30",4399);
    }

    @Override
    public TV makeTV() {
        return new HWTV("华为智慧电视",1299);
    }
}

class MiFactory implements factory{

    @Override
    public Phone makePhone() {
        return new MiPhone("小米10",4999);
    }

    @Override
    public TV makeTV() {
        return new MiTV("小米电视",1000);
    }
}


public class abstractFactory {
    public static void main(String[] args) {
        factory f = new HWFactory();
        Phone phone = f.makePhone();
        System.out.println(phone.name +" "+ phone.price);
    }
}
