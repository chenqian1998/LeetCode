package 语法.tryCatchFinally;

import org.junit.Test;

public class testDemo {

    static class in {

    }

    public static void main(String[] args) {
        //System.out.println(test());
        //int i = test02();
        System.out.println(test03());
        //System.out.println(test04());
    }

    private static String test() {
        try {
            int num = 5 / 0;
            return "a";
        } catch (Exception e) {
            e.printStackTrace();
            return "b";
        } finally {
//            System.out.println("c");
            return "c";
        }
        // return "d";
    }


    public static int test02() {
        try {
            int i = 10 / 0;
            return 10;
        } finally {
            return 30;
        }
    }

    public static int test03() {
        int i = 10;
        try {
            return i;
        } finally {
//            return 20;
            System.out.println("finally");
        }
    }

    public static int test04() {
        int i = 10;
        try {
            return i;
        } finally {
            i = 20;
        }
    }
}
