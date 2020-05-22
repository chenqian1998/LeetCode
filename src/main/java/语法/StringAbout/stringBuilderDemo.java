package 语法.StringAbout;

public class stringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("金牌");
        stringBuilder.append(10);
        stringBuilder.append('c');
        stringBuilder.append(",大司马");

        System.out.println(stringBuilder+"..."+stringBuilder.toString());

        stringBuilder.insert(0,"十年王者:");
        System.out.println(stringBuilder);

    }
}
