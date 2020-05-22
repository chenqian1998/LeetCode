package netty.nio;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        Selector selector = Selector.open();

        // 端口,由serverSocketChannel监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        // 非阻塞
        serverSocketChannel.configureBlocking(false);

        //把serverSocketChannel注册到selector，关心事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 循环等待客户端连接
        while (true) {
            // 1s内无连接建立
            if (selector.select(1000) == 0) {
                System.out.println("服务器等待1s，无连接");
                continue;
            }

            // 有事件发生，获取所有的事件的key
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                // 主要就是判断通道发生的事件，read,write,acc,connect
                defineEventByKey(serverSocketChannel,selector,key,iterator);
            }
        }
    }

    public static void defineEventByKey(ServerSocketChannel serverSocketChannel, Selector selector, SelectionKey key,Iterator<SelectionKey> iterator) throws IOException {
        if (key.isAcceptable()) {
            // 新的连接会 对应一个 SocketChannel
            SocketChannel socketChannel = serverSocketChannel.accept();

            // SocketChannel设置为非阻塞
            socketChannel.configureBlocking(false);

            System.out.println("客户端连接成功,生成一个socketChannel：" + socketChannel.hashCode());

            // socketChannel注册到selector,关注事件为读
            // 关联一个Buffer
            socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
        }

        // 发生读事件
        if (key.isReadable()) {
            // 通过key获取对应的channel
            SocketChannel channel = (SocketChannel) key.channel();

            // 得到对应buffer里的数据
            ByteBuffer buffer = (ByteBuffer) key.attachment();
            channel.read(buffer);
            System.out.println("from 客户端 " + new String(buffer.array()));

            // 需要移除这个selectionKey，因为多线程的时候会出现重复处理的问题
            iterator.remove();
        }
    }
}
