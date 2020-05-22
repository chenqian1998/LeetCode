package 语法.内部类;



public class Out {
    private int age = 100;

    private class Int {
        int age = 1;

        public void print() {
            System.out.println(Out.this.age);
            System.out.println(this.age);
        }
    }

    static class sIn {

    }

    public static void main(String[] args) {
        Int in = new Out().new Int();
        in.print();
    }

}
