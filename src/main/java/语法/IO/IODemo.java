package 语法.IO;

import org.junit.Test;

import java.io.*;

public class IODemo {
    public static void main(String[] args) throws IOException {
        /**
         * 首先就要说明的是两大类别，字节流和字符流的区别
         *
         */
        test01();


    }

    public static void test01() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符");
        char c;
        c = (char) bufferedReader.read();
        System.out.println("你输入的字符是： " + c);
    }

    /**
     * 二进制文件的写入和读取
     */
    @Test
    public void test02() throws IOException {
        System.out.println(IODemo.class.getName());
        byte[] bytes = {12, 13, 4, 56, 6};
        FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/liulixiashu/Workspace/IdeaProjects/javaProgram/src/main/java/语法/IO/test.txt"));
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

    @Test
    public void test03() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/liulixiashu/Workspace/IdeaProjects/javaProgram/src/main/java/语法/IO/test.txt");
        int c;
        while ((c = fileInputStream.read()) != -1) {
            System.out.println(c);
        }
    }


    /**
     * 文件的读取和写入
     */
    @Test
    public void test04() throws IOException {
        FileWriter fileWriter = new FileWriter("/Users/liulixiashu/Workspace/IdeaProjects/javaProgram/src/main/java/语法/IO/test2.txt");
        fileWriter.write("Hello，world！\\n欢迎来到 java 世界\\n");
        fileWriter.write("不会覆盖文件原本的内容\n");
        fileWriter.append("并不是追加一行内容，不要被方法名迷惑\n");
        fileWriter.append(null);
        fileWriter.flush();
        System.out.println("默认的编码方式：" + fileWriter.getEncoding());
        fileWriter.close();
    }

    @Test
    public void test05() throws IOException {
        FileReader fileReader = new FileReader("/Users/liulixiashu/Workspace/IdeaProjects/javaProgram/src/main/java/语法/IO/test2.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        fileReader.close();
        bufferedReader.close();
    }


}
