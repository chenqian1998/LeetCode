package 语法.StringAbout;

public class 字符串常量池 {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;

        // false 这个是因为，字节码里面用的是stringbuilder拼接的办法
        // 主要s1,s2是变量，其实可能会改变的，所以还是会用sb拼接的方式
        System.out.println(s3 == s4);

        // ture 都是字符串常量池里的，s5会在编译期间优化的，就已经确定成"ab"
        String s5 = "a" + "b";

        System.out.println(s3 == s5);
    }
}
