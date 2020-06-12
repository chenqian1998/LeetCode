package 序列化;


import domain.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class serializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
        所谓的序列化，其实就是将对象信息写入IO流中。
        因为像web这种服务，信息上传接受，都需要把Java资源写入硬盘，然后再发送。

        所以序列化提供的作用就是：将java对象转换成字节序列，这些字节序列可以保存在磁盘上，
        或通过网络传输，以达到以后恢复成原来的对象。序列化机制使得对象可以脱离程序的运行而独立存在。
         */
        // 序列化，将对象写入文件
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/main/java/基础/序列化/person.txt"));
//        Person p = new Person("aaa",22,null);
//        objectOutputStream.writeObject(p);

        // 反序列化，从文件中读取
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/main/java/基础/序列化/person.txt"));
        Person person = (Person) objectInputStream.readObject();
        System.out.println(person);

    }
}
