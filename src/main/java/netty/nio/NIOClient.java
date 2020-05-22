package netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        // 设置非阻塞
        socketChannel.configureBlocking(false);

        // 这个的含义是建立服务端的IP port
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);

        // 连接服务器
        if (!socketChannel.connect(inetSocketAddress)) {
            // 如果连接不成功，上面判断为false，进入if里面
            // 这个连接是非阻塞的，imp
            while (!socketChannel.finishConnect()) {
                System.out.println("因为连接需要时间，客户端不会阻塞，可以做其他任务。。。");
            }
        }

        String str = "NIO,niupi";
        // 输入一个字节数组到bufffer中
        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
        // 将buffer数据写入channel
        socketChannel.write(buffer);
        System.in.read();
    }
}


