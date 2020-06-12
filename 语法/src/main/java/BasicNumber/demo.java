package BasicNumber;

public class demo {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        System.out.println(a);
        // a是int的最大值， a+1,竟然成了最小值，其实从二进制上可以看出来01111。。+》1000
        System.out.println(a+1);
        System.out.println(a+2);

        int b = Integer.MIN_VALUE;
        System.out.println(b);
        // b是最小值，b竟然可以-1之后成为最大值，奇怪的知识增长了
        System.out.println(b-1);

    }
}
